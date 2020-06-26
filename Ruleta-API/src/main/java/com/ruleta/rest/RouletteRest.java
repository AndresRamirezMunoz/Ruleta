package com.ruleta.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruleta.dao.RouletteDao;
import com.ruleta.entity.Roulette;

@RestController
@RequestMapping("roulette")
public class RouletteRest {

	@Autowired
	private RouletteDao rouletteDao;

	@PostMapping
	public ResponseEntity<Roulette> createRoulette(@RequestBody Roulette roulette) {
		Roulette newRoulette = rouletteDao.save(roulette);
		return ResponseEntity.ok(newRoulette);
	}

	@PutMapping(value = "open/{rouletteId}")
	public ResponseEntity<Roulette> OpenRouletteById(@PathVariable("rouletteId") int rouletteId) {
		Optional<Roulette> optionalRoulette = rouletteDao.findById(rouletteId);
		if (optionalRoulette.isPresent()) {
			Roulette updateRoulette = optionalRoulette.get();
			updateRoulette.setOpen(true);
			updateRoulette.setEndTime(null);
			updateRoulette.setStarTime(new Date());
			rouletteDao.save(updateRoulette);
			return ResponseEntity.ok(updateRoulette);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping(value = "close/{rouletteId}")
	public String closeRouletteById(@PathVariable("rouletteId") int rouletteId) {
		Optional<Roulette> optionalRoulette = rouletteDao.findById(rouletteId);
		if (optionalRoulette.isPresent()) {
			Roulette updateRoulette = optionalRoulette.get();
			updateRoulette.setOpen(false);
			updateRoulette.setEndTime(new Date());
			rouletteDao.save(updateRoulette);
			return "Recaudo total: " + updateRoulette.getValueByDate();
		} else {
			return "";
		}
	}

	@GetMapping
	public ResponseEntity<List<Roulette>> getRoulettes() {
		List<Roulette> roulettes = rouletteDao.findAll();
		return ResponseEntity.ok(roulettes);
	}

	@RequestMapping(value = "{rouletteId}")
	public ResponseEntity<Roulette> getRouletteById(@PathVariable("rouletteId") int rouletteId) {
		Optional<Roulette> optionalRoulette = rouletteDao.findById(rouletteId);
		if (optionalRoulette.isPresent())
			return ResponseEntity.ok(optionalRoulette.get());
		else
			return ResponseEntity.noContent().build();
	}

}
