package com.orangeblue.myboard.repository;

import com.orangeblue.myboard.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User,Long>, QuerydslPredicateExecutor<User>{
    User findByUsername(String name);
}
