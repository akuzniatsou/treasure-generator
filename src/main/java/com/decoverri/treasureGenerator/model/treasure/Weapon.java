package com.decoverri.treasureGenerator.model.treasure;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.decoverri.treasureGenerator.enums.MagicWeaponAbilityRestriction;
import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.enums.WeaponType;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Interval;

@Entity
public class Weapon implements Treasure {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private double price;

	@Enumerated(EnumType.STRING)
	private WeaponType type;

	@Enumerated(EnumType.STRING)
	private MagicWeaponAbilityRestriction restriction;

	@Transient
	private Size size;

	@Embedded
	private Interval interval;

	@Override
	public double getTreasureValue() {
		return getMasterworkPrice();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return "Masterwork " + name;
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

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	public MagicWeaponAbilityRestriction getRestriction() {
		return restriction;
	}

	public void setRestriction(MagicWeaponAbilityRestriction restriction) {
		this.restriction = restriction;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	
	public double getMasterworkPrice() {
		return this.price + 300.0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.size != null && this.size != Size.MEDIUM) {
			builder.append(this.size + " ");
		}

		builder.append("masterwork " + this.name + " (price " + getMasterworkPrice() + "gp)");

		String string = builder.toString();
		return string.toUpperCase().substring(0, 1) + string.toLowerCase().substring(1);
	}
}
