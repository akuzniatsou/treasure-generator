package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.RingDao;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.Ring;
import com.decoverri.treasureGenerator.model.RingGeneratorData;

public class RingGenerator {

	private Session session;

	public RingGenerator(Session session) {
		this.session = session;
	}

	public List<Ring> generate(List<RingGeneratorData> ringsData) {

		List<Ring> rings = new ArrayList<Ring>();
		RingDao ringDao = new RingDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (RingGeneratorData data : ringsData) {
			for (int i = 0; i < data.getQuantity(); i++) {
				System.out.println("Generating " + data.getStrength() + " ring");
				Ring item = ringDao.getRing(data.getStrength(), roller.roll(d100));
				System.out.println("Result: " + item.getName() + "\n");
				rings.add(item);
			}
		}

		return rings;
	}


}
