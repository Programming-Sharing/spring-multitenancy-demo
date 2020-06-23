package com.ps.springmultitenancydemo.datasource.tenant;

import com.ps.springmultitenancydemo.datasource.lookup.TenantIdentifierLookupProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiTenantRoutingPooledDataSource extends AbstractRoutingPooledDataSource{
    @Autowired
    private TenantIdentifierLookupProvider tenantIdentifierLookupProvider;

    @Override
    protected Object determineCurrentLookupKey() {
        return tenantIdentifierLookupProvider.getTenantDataSourceKey();
    }
}
