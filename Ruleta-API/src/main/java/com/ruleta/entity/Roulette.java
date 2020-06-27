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
	@Column(name = "state", nullable = false, length = 30)
	private String state;
	@Column(name = "startime")
	private Date startTime;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void openRoulette() {
		state = "abierta";
		endTime = null;
		startTime = new Date();
	}

	public void closeRoulette() {
		state = "cerrada";
		endTime = new Date();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date starTime) {
		this.startTime = starTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
