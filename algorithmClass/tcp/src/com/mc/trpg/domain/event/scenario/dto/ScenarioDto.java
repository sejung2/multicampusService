package com.mc.trpg.domain.event.scenario.dto;

import java.util.Map;

public record ScenarioDto(
        String scenario
) {
    public static ScenarioDto fromMap(Map<String, Object> map) {
        return new ScenarioDto((String) map.get("scenario"));
    }
}
