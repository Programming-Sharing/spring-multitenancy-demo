package com.ps.springmultitenancydemo.datasource.tenant;

import com.ps.springmultitenancydemo.datasource.constant.TenantConfigMap;
import com.ps.springmultitenancydemo.repository.mst.TenantConfigValueRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public abstract class AbstractRoutingPooledDataSource extends AbstractRoutingDataSource {

    private Map<String, DataSource> resolvedDataSources;
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";

    @Autowired
    private TenantConfigValueRepository tenantConfigValueRepository;

    @lombok.SneakyThrows
    @Override
    protected DataSource determineTargetDataSource() {
        Object dataSourceLookupKey = determineCurrentLookupKey();

        // Simple demo, do not handle case the dataSourceLookupKey is missing
        DataSource dataSource = resolvedDataSources.get(dataSourceLookupKey);
        if (null == dataSource) {
            dataSource = createNewDataSource(dataSourceLookupKey.toString());
        }

        if (null == resolvedDataSources.get(dataSourceLookupKey)) {
            throw new Exception("Unable to determine tenant data source");
        }

        return dataSource;
    }

    private DataSource createNewDataSource(String dataSourceLookupKey) {
        DataSource resolvedDataSource = resolvedDataSources.get(dataSourceLookupKey); // double check
        // DataSource haven't created
        if (null == resolvedDataSource){
            HikariDataSource resolvedPoolDataSource = new HikariDataSource();
            resolvedPoolDataSource.setPoolName(dataSourceLookupKey);
            resolvedPoolDataSource.setDriverClassName(JDBC_DRIVER);
            resolvedPoolDataSource.setUsername(tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.USERNAME).getValue());
            resolvedPoolDataSource.setPassword(tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.PASSWORD).getValue());
            resolvedPoolDataSource.setJdbcUrl(buildConnectionUrl(
                    tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.HOST).getValue(),
                    tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.PORT).getValue(),
                    tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.SCHEMA).getValue()
            ));
            // TODO implement for HikariCP
        }

        this.resolvedDataSources.put(dataSourceLookupKey, resolvedDataSource);
        return resolvedDataSource;
    }

    private String buildConnectionUrl(String host, String port, String schema){
        return "jdbc:mysql://" + host + ":" + port + "/" + schema;
    }

    @Override
    protected abstract Object determineCurrentLookupKey();
}
