package com.ps.springmultitenancydemo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tenant", schema = "multitenancy-master")
public class MstTenantEntity {
    private int idTenant;
    private String name;
    private String tenantAlias;
    private Collection<MstTenantConfigValueEntity> tenantConfigValuesByIdTenant;
    private Collection<MstTenantUserEntity> tenantUsersByIdTenant;

    @Id
    @Column(name = "id_tenant")
    public int getIdTenant() {
        return idTenant;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tenantAlias")
    public String getTenantAlias() {
        return tenantAlias;
    }

    public void setTenantAlias(String tenantAlias) {
        this.tenantAlias = tenantAlias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstTenantEntity that = (MstTenantEntity) o;
        return idTenant == that.idTenant &&
                Objects.equals(name, that.name) &&
                Objects.equals(tenantAlias, that.tenantAlias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTenant, name, tenantAlias);
    }

    @OneToMany(mappedBy = "tenantByIdTenant")
    public Collection<MstTenantConfigValueEntity> getTenantConfigValuesByIdTenant() {
        return tenantConfigValuesByIdTenant;
    }

    public void setTenantConfigValuesByIdTenant(Collection<MstTenantConfigValueEntity> tenantConfigValuesByIdTenant) {
        this.tenantConfigValuesByIdTenant = tenantConfigValuesByIdTenant;
    }

    @OneToMany(mappedBy = "tenantByTenantid")
    public Collection<MstTenantUserEntity> getTenantUsersByIdTenant() {
        return tenantUsersByIdTenant;
    }

    public void setTenantUsersByIdTenant(Collection<MstTenantUserEntity> tenantUsersByIdTenant) {
        this.tenantUsersByIdTenant = tenantUsersByIdTenant;
    }
}
