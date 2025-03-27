package io.github.webapp.service.impl;

import io.github.webapp.entity.Authentication;
import io.github.webapp.entity.LoginUser;
import io.github.webapp.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

        Authentication auth = authentication.get();
        return new LoginUser(auth.getUsername(), auth.getPassword(), Collections.emptyList());
    }
}
