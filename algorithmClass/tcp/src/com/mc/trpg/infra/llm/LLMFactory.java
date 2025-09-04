package com.mc.trpg.infra.llm;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.LLMContext;
import com.mc.llm.models.LLMProvider;

import java.util.HashMap;
import java.util.Map;

public class LLMFactory {
    public static LLMFactory INSTANCE;
    private Map<LLMProvider, BaseModel> modelMap;
    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public static LLMFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LLMFactory();
        }

        return INSTANCE;
    }

    public LLMFactory() {
        LLMContext context = new LLMContext();
        modelMap = new HashMap<>();
        modelMap.put(LLMProvider.GEMINI, context.initChatModel(API_URL, LLMProvider.GEMINI));
    }

    public BaseModel create(LLMProvider provider) {
        return modelMap.get(provider);
    }
}
