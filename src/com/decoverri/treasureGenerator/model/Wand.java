package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.interfaces.Treasure;

@Entity
public class Wand implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	private String spell;
	private int spellLevel;
	private int casterLevel;
	private double price;

	@Enumerated(EnumType.STRING)
	private MagicItemRarity rarity;

	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public int getSpellLevel() {
		return spellLevel;
	}

	public void setSpellLevel(int spellLevel) {
		this.spellLevel = spellLevel;
	}

	public int getCasterLevel() {
		return casterLevel;
	}

	public void setCasterLevel(int casterLevel) {
		this.casterLevel = casterLevel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MagicItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(MagicItemRarity rarity) {
		this.rarity = rarity;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return "Wand of " + spell.toLowerCase() + " (CL: " + casterLevel + ", 50 charges, " + price + "gp)";
	}
}
