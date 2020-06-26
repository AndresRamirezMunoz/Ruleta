package com.ruleta.dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ruleta.entity.Roulette;

public interface RouletteDao extends JpaRepository<Roulette, Integer> {

	@Query("SELECT SUM(value) FROM gamewWHERE startime BETWEEN sTime AND eTime")
	public int getValueByDateQuery(@Param("sTime") Date sTime, @Param("eTime") Date eTime);
}
