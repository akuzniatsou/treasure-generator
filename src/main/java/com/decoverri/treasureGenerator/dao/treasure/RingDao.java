package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.Ring;

@Component
public class RingDao {

	private Session session;

	@Autowired
	public RingDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Ring ring) {
		session.saveOrUpdate(ring);
	}

	public Ring getRing(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select r from Ring r where r.strength = :strength and :roll >= bottomValue and :roll <= topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (Ring) query.list().get(0);
	}

}
