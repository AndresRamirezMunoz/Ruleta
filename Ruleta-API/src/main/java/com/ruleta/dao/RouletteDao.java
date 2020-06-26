package com.ruleta.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ruleta.entity.Roulette;
public interface RouletteDao extends JpaRepository<Roulette, Integer> {

	@Query(value = "SELECT SUM(value) FROM game WHERE roulette_id=?1 AND startime BETWEEN ?2 AND ?3", nativeQuery = true)
	public int getValueByDateQuery(int id, Date sTime, Date eTime);



}
