package com.ruleta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruleta.entity.Game;

public interface GameDao extends JpaRepository<Game, Integer> {

}
