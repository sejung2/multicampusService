package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto;

public record Items<T>(
        String type,
        T properties
) {
    public Items(T properties) {
        this("OBJECT", properties);
    }
}
