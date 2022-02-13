//package com.example.demo.model;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//
//public class User implements UserDetails {
//
//    private Long id;
//    private String username;
//    private String email;
//    private String password;
//    private Boolean unlocked;
//    private UserRole role;
//    private ArrayList<Address> addressList;
//    // TODO: Payment class for Payment storage
//
//
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.name());
//        return Collections.singletonList(auth);
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return unlocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
