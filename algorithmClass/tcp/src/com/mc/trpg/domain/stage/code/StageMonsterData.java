package com.mc.trpg.domain.stage.code;

import java.util.List;

import com.mc.trpg.domain.character.code.MonsterData;

public enum StageMonsterData {

	DARK_FOREST(List.of(
		MonsterData.SLIME,
		MonsterData.GOBLIN
	), MonsterData.GOLEM);
	
	private List<MonsterData> list;
	private MonsterData boss;
	private StageMonsterData(List<MonsterData> list, MonsterData boss) {
		this.list = list;
		this.boss = boss;
	}
	
	public List<MonsterData> list(){return this.list;}
	public MonsterData boss() {return boss;}
	
	
}
