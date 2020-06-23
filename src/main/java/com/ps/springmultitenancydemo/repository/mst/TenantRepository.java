package com.ps.springmultitenancydemo.repository.mst;

import com.ps.springmultitenancydemo.entity.MstTenantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<MstTenantEntity, Integer> {

    MstTenantEntity findAllByTenantAlias(String alias);
}
