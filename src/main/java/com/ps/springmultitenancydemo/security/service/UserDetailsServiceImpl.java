package com.ps.springmultitenancydemo.security.service;

import com.ps.springmultitenancydemo.repository.mst.TenantUserRepository;
import com.ps.springmultitenancydemo.security.TenantUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements PsUserDetailsService {

    private final TenantUserRepository tenantUserRepository;

    public UserDetailsServiceImpl(TenantUserRepository tenantUserRepository) {
        this.tenantUserRepository = tenantUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TenantUserDetail user = tenantUserRepository.fi(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        user.setAuthorities(grantedAuthorities);
//
//        return user;

        return null;
    }
}
