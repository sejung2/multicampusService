package com.mc.musiccoordinator.infra.llm;

import java.util.List;
import java.util.Map;

public interface BaseRequest {

    //List<Map<String, Object>> messageToMap();
    String messageToJson();

}
