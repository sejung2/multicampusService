package com.mc.musiccoordinator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Run {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent"))
                .timeout(Duration.ofMinutes(2))
                .header("X-goog-api-key", "AIzaSyAX0oeen34Jw8JK6fu5NTQw-3Q53B9pOCI")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\r\n"
                        + "    \"contents\": [\r\n"
                        + "      {\r\n"
                        + "        \"parts\": [\r\n"
                        + "          {\r\n"
                        + "            \"text\": \"노래 추천해줘. 제목, 가수, 추천 이유를 json 포맷으로 추천해줘\"\r\n"
                        + "          }\r\n"
                        + "        ]\r\n"
                        + "      }\r\n"
                        + "    ],\r\n"
                        + "    \"generationConfig\": {\r\n"
                        + "        \"responseMimeType\": \"application/json\",\r\n"
                        + "        \"responseSchema\": {\r\n"
                        + "          \"type\": \"OBJECT\",\r\n"
                        + "            \"type\": \"OBJECT\",\r\n"
                        + "            \"properties\": {\r\n"
                        + "              \"name\": { \"type\": \"STRING\" },\r\n"
                        + "              \"artist\": {\"type\":\"STRING\"},\r\n"
                        + "              \"reason\": {\"type\":\"STRING\"}\r\n"
                        + "            },\r\n"
                        + "            \"propertyOrdering\": [\"name\", \"artist\", \"reason\"]\r\n"
                        + "        }\r\n"
                        + "    }"
                        + "  }"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
