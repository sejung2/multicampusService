package com.mc.trpg.domain.stage.code;

import java.util.List;

import com.mc.trpg.domain.item.code.EquipmentData;

public enum StageEquipmentData {

	DARK_FOREST(List.of(
			EquipmentData.WOOD_ARMOR,
			EquipmentData.WOOD_AXE,
			EquipmentData.WOOD_BOOTS,
			EquipmentData.WOOD_SWORD
	), EquipmentData.KATANA);
	
	final List<EquipmentData> list;
	final EquipmentData clearReward;
	
	private StageEquipmentData(List<EquipmentData> list, EquipmentData reward) {
		this.list = list;
		this.clearReward = reward;
	}
	
	public List<EquipmentData> list(){
		return this.list;
	}
	
	public EquipmentData reward() {
		return this.clearReward;
	}
	
}
