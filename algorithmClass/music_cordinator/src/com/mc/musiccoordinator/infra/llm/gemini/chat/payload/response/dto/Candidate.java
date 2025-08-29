package com.mc.musiccoordinator.infra.llm.gemini.chat.payload.response.dto;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.Content;

public record Candidate(
        Content content
) {

}
