package com.ps.springmultitenancydemo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MstTenantConfigValueEntityPK implements Serializable {
    private int idTenant;
    private int idTenantConfigTyp;

    @Column(name = "id_tenant")
    @Id
    public int getIdTenant() {
        return idTenant;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    @Column(name = "id_tenant_config_typ")
    @Id
    public int getIdTenantConfigTyp() {
        return idTenantConfigTyp;
    }

    public void setIdTenantConfigTyp(int idTenantConfigTyp) {
        this.idTenantConfigTyp = idTenantConfigTyp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstTenantConfigValueEntityPK that = (MstTenantConfigValueEntityPK) o;
        return idTenant == that.idTenant &&
                idTenantConfigTyp == that.idTenantConfigTyp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTenant, idTenantConfigTyp);
    }
}
