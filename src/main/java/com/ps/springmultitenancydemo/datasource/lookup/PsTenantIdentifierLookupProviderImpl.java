package com.ps.springmultitenancydemo.datasource.lookup;

import com.ps.springmultitenancydemo.security.TenantUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class PsTenantIdentifierLookupProviderImpl implements TenantIdentifierLookupProvider {

    @Override
    public String getTenantDataSourceKey() {
        return ((TenantUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTenantId();
    }
}
