package com.decoverri.treasureGenerator.model.reward;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.interfaces.TreasureReward;
import com.decoverri.treasureGenerator.model.data.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.data.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.data.RingGeneratorData;
import com.decoverri.treasureGenerator.model.data.RodGeneratorData;
import com.decoverri.treasureGenerator.model.data.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.data.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.data.WandGeneratorData;
import com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData;

@Entity
public class ITreasureReward implements TreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

	@OneToMany
	private List<MagicArmorGeneratorData> armors;

	@OneToMany
	private List<MagicWeaponGeneratorData> weapons;

	@OneToMany
	private List<RingGeneratorData> rings;

	@OneToMany
	private List<StaffGeneratorData> staves;

	@OneToMany
	private List<RodGeneratorData> rods;

	@OneToMany
	private List<WondrousItemGeneratorData> wondrousItems;

	@OneToMany
	private List<PotionGeneratorData> potions;

	@OneToMany
	private List<ScrollGeneratorData> scrolls;

	@OneToMany
	private List<WandGeneratorData> wands;

	@OneToMany
	private List<GemstoneGeneratorData> gems;

	@OneToMany
	private List<ArtObjectGeneratorData> arts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<CoinGeneratorData> getCoins() {
		return coins;
	}

	public void setCoins(List<CoinGeneratorData> coins) {
		this.coins = coins;
	}

	public List<MagicArmorGeneratorData> getArmors() {
		return armors;
	}

	public void setArmors(List<MagicArmorGeneratorData> armors) {
		this.armors = armors;
	}

	public List<MagicWeaponGeneratorData> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<MagicWeaponGeneratorData> weapons) {
		this.weapons = weapons;
	}

	public List<RingGeneratorData> getRings() {
		return rings;
	}

	public void setRings(List<RingGeneratorData> rings) {
		this.rings = rings;
	}

	public List<StaffGeneratorData> getStaves() {
		return staves;
	}

	public void setStaves(List<StaffGeneratorData> staves) {
		this.staves = staves;
	}

	public List<RodGeneratorData> getRods() {
		return rods;
	}

	public void setRods(List<RodGeneratorData> rods) {
		this.rods = rods;
	}

	public List<WondrousItemGeneratorData> getWondrousItems() {
		return wondrousItems;
	}

	public void setWondrousItems(List<WondrousItemGeneratorData> wondrousItems) {
		this.wondrousItems = wondrousItems;
	}

	public List<PotionGeneratorData> getPotions() {
		return potions;
	}

	public void setPotions(List<PotionGeneratorData> potions) {
		this.potions = potions;
	}

	public List<ScrollGeneratorData> getScrolls() {
		return scrolls;
	}

	public void setScrolls(List<ScrollGeneratorData> scrolls) {
		this.scrolls = scrolls;
	}

	public List<WandGeneratorData> getWands() {
		return wands;
	}

	public void setWands(List<WandGeneratorData> wands) {
		this.wands = wands;
	}

	public List<GemstoneGeneratorData> getGems() {
		return gems;
	}

	public void setGems(List<GemstoneGeneratorData> gems) {
		this.gems = gems;
	}

	public List<ArtObjectGeneratorData> getArts() {
		return arts;
	}

	public void setArts(List<ArtObjectGeneratorData> arts) {
		this.arts = arts;
	}

}
