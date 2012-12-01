package br.com.metalgames.treasureGenerator.model;

import br.com.metalgames.treasureGenerator.interfaces.Treasure;

public class Gemstone implements Treasure {

	private String name;
	private GemGrade grade;
	private Interval chanceInterval;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GemGrade getGrade() {
		return grade;
	}

	public void setGrade(GemGrade grade) {
		this.grade = grade;
	}

	public Interval getChanceInterval() {
		return chanceInterval;
	}

	public void setChanceInterval(Interval chanceInterval) {
		this.chanceInterval = chanceInterval;
	}

	@Override
	public String toString() {
		return name;
	}
}
