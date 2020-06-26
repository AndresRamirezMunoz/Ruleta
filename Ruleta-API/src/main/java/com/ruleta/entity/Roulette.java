package com.ruleta.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roulette")
public class Roulette {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "isopen", nullable = false)
	private boolean isOpen;
	@Column(name = "startime")
	private Date starTime;
	@Column(name = "endtime")
	private Date endTime;
	@OneToMany(mappedBy = "roulette", cascade = CascadeType.ALL)
	private List<Game> games = new ArrayList<>();

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Date getStarTime() {
		return starTime;
	}

	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getValueByDate() {
		int sum = 0;
		for (int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			if (game.getStarTime().after(starTime) && game.getStarTime().before(endTime))
				sum += game.getValue();
		}
		return sum;
	}
	
	
}
