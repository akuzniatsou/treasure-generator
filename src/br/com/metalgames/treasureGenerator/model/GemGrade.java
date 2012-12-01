package br.com.metalgames.treasureGenerator.model;

public class GemGrade {

	private int number;
	private String description;
	private GemValue value;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GemValue getValue() {
		return value;
	}

	public void setValue(GemValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Grade " + number + " gem";
	}
	
}
