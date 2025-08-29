package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.error;

public record GeminiErrorMessage(
        String code,
        String message
) {
}
