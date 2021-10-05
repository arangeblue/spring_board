package com.orangeblue.myboard.service;

import com.orangeblue.myboard.domain.Role;
import com.orangeblue.myboard.domain.RoleEnum;
import com.orangeblue.myboard.domain.User;
import com.orangeblue.myboard.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void userSave(User user, RoleEnum roleEnum) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRole(roleEnum);
        userRepository.save(user);

    }
    
}
