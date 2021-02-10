package com.springsecurityboilerplate.springsecurity.config.security.service;

import com.springsecurityboilerplate.model.AuthenticationRequest;
import com.springsecurityboilerplate.model.AuthenticationResponse;
import com.springsecurityboilerplate.springsecurity.config.security.jwt.JwtProvider;
import com.springsecurityboilerplate.springsecurity.data.entity.Users;
import com.springsecurityboilerplate.springsecurity.data.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 11:41 PM
 * @project springsecurity
 */
@Transactional
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepo repo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users createUser(Users user) {
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
    @Override
    public ResponseEntity<?> signIn(AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (Exception e) {
            log.warn("Failed to sign in", e);
            return new ResponseEntity<>("Wrong password!", HttpStatus.UNAUTHORIZED);
        }
    }
}
