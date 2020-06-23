package com.ps.springmultitenancydemo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tenant_user", schema = "multitenancy-master", catalog = "")
@IdClass(MstTenantUserEntityPK.class)
public class MstTenantUserEntity {
    private String username;
    private int tenantid;
    private String password;
    private MstTenantEntity tenantByTenantid;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "tenantid")
    public int getTenantid() {
        return tenantid;
    }

    public void setTenantid(int tenantid) {
        this.tenantid = tenantid;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstTenantUserEntity that = (MstTenantUserEntity) o;
        return tenantid == that.tenantid &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, tenantid, password);
    }

    @ManyToOne
    @JoinColumn(name = "tenantid", referencedColumnName = "id_tenant", nullable = false)
    public MstTenantEntity getTenantByTenantid() {
        return tenantByTenantid;
    }

    public void setTenantByTenantid(MstTenantEntity tenantByTenantid) {
        this.tenantByTenantid = tenantByTenantid;
    }
}
