package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.nhnacademy.residentmanage.entity.User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return new User(user.getMemberId(), user.getPwd(),
                Collections.singleton(new SimpleGrantedAuthority(user.getAuthority().getAuthority())));
    }
}
