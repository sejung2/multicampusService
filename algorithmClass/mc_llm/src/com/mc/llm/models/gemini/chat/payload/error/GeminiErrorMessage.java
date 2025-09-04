package com.mc.llm.models.gemini.chat.payload;

public record GeminiErrorMessage(
		String code,
		String message
	) {
}
