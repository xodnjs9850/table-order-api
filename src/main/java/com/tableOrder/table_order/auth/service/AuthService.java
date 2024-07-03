package com.tableOrder.table_order.auth.service;

import com.tableOrder.table_order.auth.model.CustomUserDetails;
import com.tableOrder.table_order.auth.model.Token;
import com.tableOrder.table_order.user.entity.UserEntity;
import com.tableOrder.table_order.user.model.UserRole;
import com.tableOrder.table_order.user.repository.UserRepository;
import com.tableOrder.table_order.util.JwtUtil;
import com.tableOrder.table_order.util.exception.BadCredentialsException;
import com.tableOrder.table_order.util.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    static Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Optional<String> signUp(
            final String email,
            final String password,
            final String userName
    ) {

        if (userRepository.existsByEmail(email)){
            throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");
        }

        UserEntity newUser =
                UserEntity.builder()
                        .email(email)
                        .userRole(UserRole.UNAUTHORIZED_USER)
                        .name(userName)
                        .encryptedPassword(passwordEncoder.encode(password))
                        .password(password)
                        .build();

        UserEntity savedUser = userRepository.save(newUser);
        return Optional.of(savedUser.getEmail());
    }


    public Optional<Token> signIn(final String email, final String password) {
        var user =
                userRepository.findByEmail(email)
                        .orElseThrow(() -> new BadCredentialsException("유저를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, user.getEncryptedPassword())) {
            throw new BadCredentialsException("패스워드가 일치하지 않습니다.");
        }
        return refreshCredentialsToken(user);
    }



    private Optional<Token> refreshCredentialsToken(final UserEntity user) {
        var userDetails = CustomUserDetails.builder().user(user).build();

        var extraClaims = new HashMap<String, Object>();
        extraClaims.put("role", user.getUserRole().getPermission());
        extraClaims.put("id", user.getId());

        var token = jwtUtil.generateToken(extraClaims, userDetails);
        var refreshToken = jwtUtil.generateRefreshToken(userDetails);

        user.setRefreshToken(refreshToken);
        userRepository.save(user);

        return Optional.of(Token.builder().accessToken(token).refreshToken(refreshToken).build());
    }

}
