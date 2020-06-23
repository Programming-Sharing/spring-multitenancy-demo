package com.ps.springmultitenancydemo.datasource.tenant;

import com.ps.springmultitenancydemo.datasource.constant.TenantConfigMap;
import com.ps.springmultitenancydemo.entity.MstTenantEntity;
import com.ps.springmultitenancydemo.repository.mst.TenantConfigValueRepository;
import com.ps.springmultitenancydemo.repository.mst.TenantRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public abstract class AbstractRoutingPooledDataSource extends AbstractRoutingDataSource {

    private Map<String, DataSource> resolvedDataSources;

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
            resolvedPoolDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            resolvedPoolDataSource.setUsername(tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.USERNAME).getValue());
            resolvedPoolDataSource.setPassword(tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.PASSWORD).getValue());
            resolvedPoolDataSource.setUsername(tenantConfigValueRepository.getConfigValue(dataSourceLookupKey, TenantConfigMap.USERNAME).getValue());

            // TODO implement for HikariCP
        }

        this.resolvedDataSources.put(dataSourceLookupKey, resolvedDataSource);
        return resolvedDataSource;
    }

    @Override
    protected abstract Object determineCurrentLookupKey();
}
