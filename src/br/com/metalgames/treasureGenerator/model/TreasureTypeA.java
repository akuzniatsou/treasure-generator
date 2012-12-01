package br.com.metalgames.treasureGenerator.model;

import static br.com.metalgames.treasureGenerator.enums.Currency.CP;
import static br.com.metalgames.treasureGenerator.enums.Currency.GP;
import static br.com.metalgames.treasureGenerator.enums.Currency.PP;
import static br.com.metalgames.treasureGenerator.enums.Currency.SP;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.metalgames.treasureGenerator.config.HibernateUtil;
import br.com.metalgames.treasureGenerator.dao.CoinRewardDao;
import br.com.metalgames.treasureGenerator.enums.Currency;
import br.com.metalgames.treasureGenerator.interfaces.Treasure;
import br.com.metalgames.treasureGenerator.interfaces.TreasureType;


public class TreasureTypeA implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	DiceRoller roller = new DiceRoller();

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		CoinRewardDao dao = new CoinRewardDao(session);
		CoinReward coinReward = dao.findByValue(value);

		if (coinReward.getCpNumberOfDice() != 0) {
			Dice baseDice = new Dice(coinReward.getCpBaseDiceSize());
			Coins copperPieces = generatePieces(CP, coinReward.getCpNumberOfDice(), baseDice, coinReward.getCpMultiplier());
			treasures.add(copperPieces);
		}
		if (coinReward.getSpNumberOfDice() != 0) {
			Dice baseDice = new Dice(coinReward.getSpBaseDiceSize());
			Coins silverPieces = generatePieces(SP, coinReward.getSpNumberOfDice(), baseDice, coinReward.getSpMultiplier());
			treasures.add(silverPieces);
		}
		if (coinReward.getGpNumberOfDice() != 0) {
			Dice baseDice = new Dice(coinReward.getGpBaseDiceSize());
			Coins goldPieces = generatePieces(GP, coinReward.getGpNumberOfDice(), baseDice, coinReward.getGpMultiplier());
			treasures.add(goldPieces);
		}
		if (coinReward.getPpNumberOfDice() != 0) {
			Dice baseDice = new Dice(coinReward.getPpBaseDiceSize());
			Coins platinumPieces = generatePieces(PP, coinReward.getPpNumberOfDice(), baseDice, coinReward.getPpMultiplier());
			treasures.add(platinumPieces);
		}

		return treasures;
	}

	private Coins generatePieces(Currency currency, int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("-Generating " + currency);
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, currency);
	}

	@Override
	public String toString() {
		return "type A";
	}
}
