package com.ps.springmultitenancydemo.repository.mst;

import com.ps.springmultitenancydemo.entity.MstTenantConfigValueEntity;
import com.ps.springmultitenancydemo.entity.MstTenantConfigValueEntityPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;

@Repository
public interface TenantConfigValueRepository extends CrudRepository<MstTenantConfigValueEntity, MstTenantConfigValueEntityPK> {

    @Query("select cv from  MstTenantConfigValueEntity cv where cv.idTenantConfigTyp =:configTyp and cv.tenantByIdTenant.tenantAlias =:tenantAlias")
    MstTenantConfigValueEntity getConfigValue(String tenantAlias, int configTyp);


}
