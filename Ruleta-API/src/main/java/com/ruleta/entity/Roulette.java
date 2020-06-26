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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roulette")
public class Roulette {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "state", nullable = false)
	private boolean state;
	@Column(name = "startime")
	private Date starTime;
	@Column(name = "endtime")
	private Date endTime;
	@JsonIgnore
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

	public void openRoulette() {
		state = true;
		endTime = null;
		starTime = new Date();
	}

	public void closeRoulette() {
		state = false;
		endTime = new Date();
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

}
