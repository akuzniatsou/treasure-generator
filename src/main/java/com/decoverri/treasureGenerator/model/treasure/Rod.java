package com.decoverri.treasureGenerator.model.treasure;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class Rod implements Treasure, Cloneable {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private double price;

	private int metamagicSpellLevelIncrement;

	@Enumerated(EnumType.STRING)
	private MagicItemStrength strength;

	@Embedded
	private Interval interval;

	@Override
	public double getTreasureValue() {
		return getPrice();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMetamagicSpellLevelIncrement() {
		return metamagicSpellLevelIncrement;
	}

	public void setMetamagicSpellLevelIncrement(int metamagicSpellLevelIncrement) {
		this.metamagicSpellLevelIncrement = metamagicSpellLevelIncrement;
	}

	public MagicItemStrength getStrength() {
		return strength;
	}

	public void setStrength(MagicItemStrength strength) {
		this.strength = strength;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return name + " (" + price + "gp)";
	}

	@Override
	public Rod clone(){
		Rod rod = new Rod();
		rod.setId(id);
		rod.setInterval(interval);
		rod.setMetamagicSpellLevelIncrement(metamagicSpellLevelIncrement);
		rod.setName(name);
		rod.setPrice(price);
		rod.setStrength(strength);
		return rod;
	}

	@Override
	public String getTreasureName() {
		return getName();
	}

}
