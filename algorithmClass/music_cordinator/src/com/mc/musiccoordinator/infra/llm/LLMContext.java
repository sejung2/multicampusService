package com.mc.musiccoordinator.infra.llm;

import com.mc.musiccoordinator.infra.llm.gemini.chat.GeminiChatModel;

public class LLMContext {

    public BaseModel initChatModel(String url, LLMProvider provider) {
        return switch(provider) {
            case GEMINI -> GeminiChatModel.getInstance(url);
        };
    };
}
