package com.decoverri.treasureGenerator.model.reward;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.interfaces.TreasureReward;
import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.data.GemstoneGeneratorData;

@Entity
public class BTreasureReward implements TreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<CoinGeneratorData> coins;

	@OneToMany
	private List<GemstoneGeneratorData> gems;

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

	public List<GemstoneGeneratorData> getGems() {
		return gems;
	}

	public void setGems(List<GemstoneGeneratorData> gems) {
		this.gems = gems;
	}

}
