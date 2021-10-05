package com.orangeblue.myboard.repository;

import com.orangeblue.myboard.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
     
}
