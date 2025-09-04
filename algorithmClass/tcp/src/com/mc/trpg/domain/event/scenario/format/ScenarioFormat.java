package com.mc.trpg.domain.event.scenario.format;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

public record ScenarioFormat(
        SchemaType scenario
) implements Format {
    public static final com.mc.trpg.domain.event.scenario.format.ScenarioFormat format =
            new com.mc.trpg.domain.event.scenario.format.ScenarioFormat(SchemaType.STRING);
}
