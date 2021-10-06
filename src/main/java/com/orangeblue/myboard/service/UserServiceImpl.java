package com.orangeblue.myboard.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.orangeblue.myboard.domain.Role;
import com.orangeblue.myboard.domain.RoleEnum;
import com.orangeblue.myboard.domain.User;
import com.orangeblue.myboard.domain.UserRole;
import com.orangeblue.myboard.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void userSave(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        user.setPassword(encodedPassword);
        user.setEnabled(true);
        
        Role role = new Role();
        role.setName(user.getRole());
        
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        
        

        em.persist(role);
        em.persist(userRole);
        em.persist(user);
    }
    
}
