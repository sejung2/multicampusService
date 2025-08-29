package com.mc.musiccoordinator.domain.song;

import com.mc.musiccoordinator.infra.llm.gemini.chat.Format;
import com.mc.musiccoordinator.infra.llm.gemini.chat.code.SchemaType;

public record SongFormat(
        SchemaType name,
        SchemaType artist,
        SchemaType reason
) implements Format {

    public static final SongFormat INSTANCE = new SongFormat(SchemaType.STRING, SchemaType.STRING, SchemaType.STRING);


}

