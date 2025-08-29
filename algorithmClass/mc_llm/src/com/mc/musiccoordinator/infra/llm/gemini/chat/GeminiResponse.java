package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.google.gson.reflect.TypeToken;
import com.mc.musiccoordinator.infra.json.JsonProvider;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.response.dto.ResponseDocument;

import java.util.List;
import java.util.Map;

public class GeminiResponse implements BaseResponse {

    private String response;

    public GeminiResponse(String response) {
        super();
        this.response = response;
    }

    @Override
    public List<Map<String, Object>> messageToMap() {
        ResponseDocument doc = JsonProvider.gson().fromJson(response, ResponseDocument.class);
        String partText = doc
                .candidates().getFirst().content().parts().getFirst().text();

        TypeToken<List<Map<String, Object>>> listType = new TypeToken<List<Map<String, Object>>>() {};
        return JsonProvider.gson().fromJson(partText, listType.getType());
    }
}
