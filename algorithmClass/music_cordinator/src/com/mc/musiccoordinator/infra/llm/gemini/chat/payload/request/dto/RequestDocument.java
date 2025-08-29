package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.Content;

import java.util.List;

public record RequestDocument<T>(
        List<Content> contents,
        GenerationConfig<T> generationConfig) {


}
