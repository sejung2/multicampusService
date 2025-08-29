package com.mc.musiccoordinator.infra.llm.gemini.chat.payload;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto.Part;

import java.util.List;

public record Content(
        List<Part> parts,
        String role
) {
    public Content(List<Part> parts) {
        this(parts, "");
    }
}
