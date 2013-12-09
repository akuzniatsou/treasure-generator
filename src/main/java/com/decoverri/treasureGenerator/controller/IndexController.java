package com.decoverri.treasureGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;
import com.decoverri.treasureGenerator.model.view.TreasureTypeInfo;

@Controller
@Scope("request")
public class IndexController {

	@Autowired
	private TreasureRewardDao rewardDao;
	@Autowired
	private TreasureGenerator generator;

	@RequestMapping("/")
	public String execute(Model model) {
		ArrayList<TreasureTypeInfo> treasuresInfo = new ArrayList<TreasureTypeInfo>();
		TreasureTypeInfo info;

		List<Character> types = rewardDao.getTypes();
		for (Character character : types) {
			info = new TreasureTypeInfo();
			info.setType(character);
			info.setValues(rewardDao.getValuesOfType(character));
			treasuresInfo.add(info);
		}

		model.addAttribute("treasureTypesInfo", treasuresInfo);
		return "index";
	}

	@RequestMapping("/generate")
	public String generate(TreasureTypeInfoList infos, Model model) {
		List<Treasure> treasures = generator.genarate(infos);
		double totalPrice = 0;
		for (Treasure treasure : treasures) {
			totalPrice += treasure.getTreasureValue();
		}
		model.addAttribute("treasures", treasures);
		model.addAttribute("totalPrice", totalPrice);
		return "forward:/";
	}
}
