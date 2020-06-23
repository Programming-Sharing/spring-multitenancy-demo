package com.ps.springmultitenancydemo.repository.mst;

import com.ps.springmultitenancydemo.entity.MstTenantUserEntity;
import com.ps.springmultitenancydemo.entity.MstTenantUserEntityPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantUserRepository extends CrudRepository<MstTenantUserEntity, MstTenantUserEntityPK> {
}
