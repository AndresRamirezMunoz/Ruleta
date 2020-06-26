package com.ruleta.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.dao.GameDao;
import com.ruleta.entity.Game;
import com.ruleta.entity.Roulette;

@RestController
@RequestMapping("game")
public class GameRest {
	@Autowired
	private GameDao gameDao;
	
	@PostMapping
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		Game newGame = gameDao.save(game);
		return ResponseEntity.ok(newGame);
	}
	
	
}
