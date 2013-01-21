package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.ArtObjectDao;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.ArtObject;

public class ArtObjectGenerator {

	private ArtObjectDao dao;
	private DiceRoller roller;
	private Dice d100;

	public ArtObjectGenerator(Session session) {
		this.dao = new ArtObjectDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}
	
	public List<ArtObject> generate(List<ArtObjectGeneratorData> artsData) {
		List<ArtObject> arts = new ArrayList<ArtObject>();
		
		for (ArtObjectGeneratorData data : artsData) {
			arts.addAll(generate(data));
		}
		
		return arts;
	}
	
	private List<ArtObject> generate(ArtObjectGeneratorData data) {
		List<ArtObject> arts = new ArrayList<ArtObject>();
		
		for (int i = 0; i < data.getQuantity(); i++) {
			arts.add(generate(data.getGrade()));
		}
		
		return arts;
	}

	private ArtObject generate(int grade) {
		System.out.println("Generating grade " + grade + " art object");

		ArtObject artObject = dao.getArt(grade, roller.roll(d100));

		System.out.println("Result: " + artObject.getName() + "\n");

		return artObject;
	}

}
