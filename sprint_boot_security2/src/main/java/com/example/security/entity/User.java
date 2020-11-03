package com.example.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Set;

@Getter
@Setter
public class User implements UserDetails {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户角色
     */
    private Set<GrantedAuthority> authorities;

    /**
     * 账号未过期
     */
    private boolean accountNonExpired = true;

    /**
     * 账号非锁定
     */
    private boolean accountNonLocked = true;

    /**
     * 凭证未过期
     */
    private boolean credentialsNonExpired = true;

    /**
     * 启用
     */
    private boolean enabled = true;


}