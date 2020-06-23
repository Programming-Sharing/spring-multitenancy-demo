package com.ps.springmultitenancydemo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tenant_config_typ", schema = "multitenancy-master", catalog = "")
public class MstTenantConfigTypEntity {
    private int idTenantConfigTyp;
    private String displayName;
    private String description;
    private Collection<MstTenantConfigValueEntity> tenantConfigValuesByIdTenantConfigTyp;

    @Id
    @Column(name = "id_tenant_config_typ")
    public int getIdTenantConfigTyp() {
        return idTenantConfigTyp;
    }

    public void setIdTenantConfigTyp(int idTenantConfigTyp) {
        this.idTenantConfigTyp = idTenantConfigTyp;
    }

    @Basic
    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstTenantConfigTypEntity that = (MstTenantConfigTypEntity) o;
        return idTenantConfigTyp == that.idTenantConfigTyp &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTenantConfigTyp, displayName, description);
    }

    @OneToMany(mappedBy = "tenantConfigTypByIdTenantConfigTyp")
    public Collection<MstTenantConfigValueEntity> getTenantConfigValuesByIdTenantConfigTyp() {
        return tenantConfigValuesByIdTenantConfigTyp;
    }

    public void setTenantConfigValuesByIdTenantConfigTyp(Collection<MstTenantConfigValueEntity> tenantConfigValuesByIdTenantConfigTyp) {
        this.tenantConfigValuesByIdTenantConfigTyp = tenantConfigValuesByIdTenantConfigTyp;
    }
}
