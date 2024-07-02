package com.tableOrder.table_order.auth.service;

import com.tableOrder.table_order.auth.model.CustomUserDetails;
import com.tableOrder.table_order.user.entity.UserEntity;
import com.tableOrder.table_order.user.repository.UserRepository;
import com.tableOrder.table_order.util.exception.BadCredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(id)
                .orElseThrow(() -> new BadCredentialsException("유저를 찾을 수 없습니다."));

        return new CustomUserDetails(user);
    }
}
