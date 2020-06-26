package com.ruleta.rest;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruleta.dao.GameDao;
import com.ruleta.dao.RouletteDao;
import com.ruleta.dao.UserDao;
import com.ruleta.entity.Game;

@RestController
@RequestMapping("game")
public class GameRest {
	@Autowired
	private GameDao gameDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RouletteDao rouletteDao;

	@PostMapping(value = "{data}")
	public ResponseEntity<Game> createGame(@PathVariable("data") String data) {
		String[] dataGame = data.split("-");
		Game game = new Game();
		game.setNumber(dataGame[0]);
		game.setColor(dataGame[1]);
		game.setValue(Integer.parseInt(dataGame[2]));
		game.setUser(userDao.findById(dataGame[3]).get());
		game.setRoulette(rouletteDao.findById(Integer.parseInt(dataGame[4])).get());
		game.setStarTime(new Date());
		Game newGame = gameDao.save(game);
		return ResponseEntity.ok(newGame);
	}

	@GetMapping
	public ResponseEntity<List<Game>> getGames() {
		List<Game> games = gameDao.findAll();
		return ResponseEntity.ok(games);
	}

}
