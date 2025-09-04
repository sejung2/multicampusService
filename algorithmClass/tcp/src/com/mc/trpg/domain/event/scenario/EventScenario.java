package com.mc.trpg.domain.event.scenario;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.LLMProvider;
import com.mc.llm.models.gemini.chat.GeminiRequest;
import com.mc.trpg.domain.event.BattleEvent;
import com.mc.trpg.domain.event.EquipmentEvent;
import com.mc.trpg.domain.event.Event;
import com.mc.trpg.domain.event.scenario.dto.ScenarioDto;
import com.mc.trpg.domain.event.scenario.format.ScenarioFormat;
import com.mc.trpg.domain.stage.code.Stage;
import com.mc.trpg.infra.llm.LLMFactory;

public class EventScenario {
    private Stage stage;
    private Event event;
    private BaseModel model = LLMFactory.getInstance().create(LLMProvider.GEMINI);

    public EventScenario(Stage stage, Event event) {
        super();
        this.stage = stage;
        this.event = event;
    }

    public void start() {
        switch (event) {
            case BattleEvent ev -> startBattleEvent();
            case EquipmentEvent ev -> startEquipementEvent();
            default -> event.proceed();
        }
    }

    private void startEquipementEvent() {
        EquipmentEvent equipmentEvent = (EquipmentEvent) event;
        String prompt = String.format("""
                너는 TRPG의 마스터야.
                %s 에서 %s 아이템을 발견하는 상황을 100자 내외의 길이로 생생하게 묘사해줘.
                응답은 아래 json Format 으로 해줘.
                {"scenario",""}
                
                """, stage.code().desc(), equipmentEvent.getEquipmentName());

        ScenarioDto dto = generateScenario(prompt);
        System.out.println(dto.scenario());
        equipmentEvent.proceed();
    }

    private void startBattleEvent() {
        BattleEvent battleEvent = (BattleEvent) event;
        String prompt = String.format("""
                너는 TRPG의 마스터야.
                %s 에서 %s 가 등장하는 상황을 100자 내외의 길이로 생생하게 묘사해줘.
                응답은 아래 json Format 으로 해줘.
                {"scenario",""}
                
                """, stage.code().desc(), battleEvent.getMonsterName());

        ScenarioDto dto = generateScenario(prompt);
        System.out.println(dto.scenario());
        battleEvent.proceed();
    }

    private ScenarioDto generateScenario(String prompt) {
        BaseResponse response = model.invoke(new GeminiRequest<ScenarioFormat>(
                prompt, ScenarioFormat.format));
        ScenarioDto dto = ScenarioDto.fromMap(response.messageToMap().getFirst());
        return dto;
    }
}
