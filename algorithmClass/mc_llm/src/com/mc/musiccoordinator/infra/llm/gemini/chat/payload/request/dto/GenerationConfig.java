package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto;

public record GenerationConfig<T>(
        String responseMimeType,
        ResponseSchema<T> responseSchema
) {

    public GenerationConfig(ResponseSchema<T> responseSchema) {
        this("application/json", responseSchema);

    }
}
