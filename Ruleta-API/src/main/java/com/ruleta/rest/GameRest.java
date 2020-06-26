package com.ruleta.rest;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruleta.dao.GameDao;
import com.ruleta.entity.Game;

@RestController
@RequestMapping("game")
public class GameRest {
	@Autowired
	private GameDao gameDao;

	@PostMapping
	public int createGame(@RequestBody Game game) {
		game.setStarTime(new Date());
		gameDao.save(game);
		return game.getId();
	}

	@GetMapping
	public ResponseEntity<List<Game>> getGames() {
		List<Game> games = gameDao.findAll();
		return ResponseEntity.ok(games);
	}

}
