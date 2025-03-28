package io.github.webapp.service.impl;

import io.github.webapp.entity.Authentication;
import io.github.webapp.entity.LoginUser;
import io.github.webapp.entity.Role;
import io.github.webapp.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService {
    private final AuthenticationRepository authenticationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Authentication> authentication = authenticationRepository.findByUsername(username);

        if (authentication.isEmpty()) {
            throw new UsernameNotFoundException(username + " 사용자 명이 없음");
        }
        LoginUser user = null;
        try {
            Authentication auth = authentication.get();
            user = new LoginUser(auth.getUsername(), auth.getPassword(), getAuthorityList(auth.getAuthority()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;

    }

    private List<GrantedAuthority> getAuthorityList(Role role) {
        // 권한 리스트
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 열거형에서 권한을 가져옴
        authorities.add(new SimpleGrantedAuthority(role.name()));
        // ADMIN 역할인 경우 USER 권한도 부여
        if (role == Role.ADMIN) {
            authorities.add(
                    new SimpleGrantedAuthority(Role.USER.toString()));
        }
        return authorities;
    }
}
