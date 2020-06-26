package com.ruleta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruleta.entity.Roulette;

public interface RouletteDao extends JpaRepository<Roulette, Integer> {

}
