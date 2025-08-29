package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.mc.musiccoordinator.infra.json.JsonProvider;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.Content;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.request.dto.*;

import java.util.List;

public class GeminiRequest<T extends Format> implements BaseRequest {

    private String content;
    private T format;

    public GeminiRequest(String content, T format) {
        super();
        this.content = content;
        this.format = format;
    }

    @Override
    public String messageToJson() {
        ResponseSchema<T> schema =
                new ResponseSchema<T>(new Items<>(format));
        GenerationConfig<T> config =
                new GenerationConfig<>(schema);
        RequestDocument<T> doc = new RequestDocument<T>(
                List.of(new Content(List.of(new Part(content)))),
                config);

        return JsonProvider.gson().toJson(doc);
    }
}
