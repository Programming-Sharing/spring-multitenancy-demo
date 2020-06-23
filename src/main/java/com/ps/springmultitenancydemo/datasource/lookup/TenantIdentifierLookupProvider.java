package com.ps.springmultitenancydemo.datasource.lookup;

public interface TenantIdentifierLookupProvider {
    String getTenantDataSourceKey();
}
