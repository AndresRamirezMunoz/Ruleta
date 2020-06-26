package com.ruleta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruleta.entity.User;

public interface UserDao extends JpaRepository<User, String> {

}
