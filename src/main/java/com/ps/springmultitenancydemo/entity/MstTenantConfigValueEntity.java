package com.ps.springmultitenancydemo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tenant_config_value", schema = "multitenancy-master", catalog = "")
@IdClass(MstTenantConfigValueEntityPK.class)
public class MstTenantConfigValueEntity {
    private int idTenant;
    private int idTenantConfigTyp;
    private String value;
    private MstTenantEntity tenantByIdTenant;
    private MstTenantConfigTypEntity tenantConfigTypByIdTenantConfigTyp;

    @Id
    @Column(name = "id_tenant")
    public int getIdTenant() {
        return idTenant;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    @Id
    @Column(name = "id_tenant_config_typ")
    public int getIdTenantConfigTyp() {
        return idTenantConfigTyp;
    }

    public void setIdTenantConfigTyp(int idTenantConfigTyp) {
        this.idTenantConfigTyp = idTenantConfigTyp;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstTenantConfigValueEntity that = (MstTenantConfigValueEntity) o;
        return idTenant == that.idTenant &&
                idTenantConfigTyp == that.idTenantConfigTyp &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTenant, idTenantConfigTyp, value);
    }

    @ManyToOne
    @JoinColumn(name = "id_tenant", referencedColumnName = "id_tenant", nullable = false)
    public MstTenantEntity getTenantByIdTenant() {
        return tenantByIdTenant;
    }

    public void setTenantByIdTenant(MstTenantEntity tenantByIdTenant) {
        this.tenantByIdTenant = tenantByIdTenant;
    }

    @ManyToOne
    @JoinColumn(name = "id_tenant_config_typ", referencedColumnName = "id_tenant_config_typ", nullable = false)
    public MstTenantConfigTypEntity getTenantConfigTypByIdTenantConfigTyp() {
        return tenantConfigTypByIdTenantConfigTyp;
    }

    public void setTenantConfigTypByIdTenantConfigTyp(MstTenantConfigTypEntity tenantConfigTypByIdTenantConfigTyp) {
        this.tenantConfigTypByIdTenantConfigTyp = tenantConfigTypByIdTenantConfigTyp;
    }
}
