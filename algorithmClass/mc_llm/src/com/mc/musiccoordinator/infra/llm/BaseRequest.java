package com.mc.musiccoordinator.infra.llm;

public interface BaseRequest {

    //List<Map<String, Object>> messageToMap();
    String messageToJson();

}
