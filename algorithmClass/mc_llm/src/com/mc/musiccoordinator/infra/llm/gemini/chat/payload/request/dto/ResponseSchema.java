package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto;

public record ResponseSchema<T>(
        String type,
        Items<T> items
) {
    public ResponseSchema(Items<T> items) {
        this("ARRAY", items);
    }
}
