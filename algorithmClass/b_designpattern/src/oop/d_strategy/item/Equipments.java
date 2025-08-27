package oop.d_strategy.item;

import oop.d_strategy.item.code.EquipmentData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 1급 컬렉션
// 1. 컬렉션에 직접 접근하는 것을 차단, 컬렉션이 불변성을 보장
// 2.비지니스 로직을 캡슐화
//  Map을 직접 사용하면 CRUD 가 모두 노출 -> 1급 컬렉션을 사용해 원하는 작업만 가능하도록 캡슐화
// 3. 이름이 명확해진다
public class Equipments {

    private final Map<Slot, Equipment> equipments;

    public Equipments() {
        equipments = new HashMap<Slot, Equipment>();
        equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
    }

    public void equip(Equipment equipment) {
        equipments.put(equipment.getSlot(), equipment);
    }

    public void unEquip(Slot slot) {
        if (slot.equals(Slot.WEAPON)) {
            equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
            return;
        }
        equipments.remove(slot);
    }

    public Collection<Equipment> findAll() {
        return equipments.values();
    }

    public Optional<Equipment> findbySlot(Slot slot) {
        return Optional.of(equipments.get(slot));
    }
}
