package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.google.gson.JsonObject;
import com.mc.musiccoordinator.infra.json.JsonProvider;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.exception.LLMException;
import com.mc.musiccoordinator.infra.llm.exception.code.ErrorCode;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payload.error.GeminiErrorMessage;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GeminiChatModel implements BaseModel {
    private static Dotenv dotenv = Dotenv.configure()
            .directory("music_cordinator")
            .load();

    private String API_URL;
    private String API_KEY;
    private static GeminiChatModel INSTANCE;

    public static GeminiChatModel getInstance(String url) {
        if (INSTANCE == null) {
            INSTANCE = new GeminiChatModel();
        }

        return INSTANCE;
    }

    private GeminiChatModel() {
        super();
        API_URL = dotenv.get("API_URL");
        API_KEY = dotenv.get("API_KEY");
        if (API_KEY == null) throw new LLMException(ErrorCode.BAD_REQUEST
                , "환경변수에 GEMINI_API_KEY 가 존재하지 않습니다.");
    }

    @Override
    public BaseResponse invoke(BaseRequest message) {
        String body = message.messageToJson();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .timeout(Duration.ofSeconds(15))
                    .header("X-goog-api-key", API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() < 200 || response.statusCode() > 299) {

                if (response.statusCode() == 404) {
                    throw new LLMException(ErrorCode.BAD_REQUEST, "잘못된 API URL 입니다.");
                }

                JsonObject jsonObject
                        = JsonProvider.gson().fromJson(response.body(), JsonObject.class);

                GeminiErrorMessage errorMessage
                        = JsonProvider.gson().fromJson(jsonObject.get("error"), GeminiErrorMessage.class);

                throw new LLMException(ErrorCode.BAD_REQUEST, errorMessage.message());
            }

            return new GeminiResponse(response.body());

        } catch (IOException | InterruptedException e) {
            throw new LLMException(ErrorCode.INTERNAL_SERVER_ERROR, e);
        } catch (RuntimeException e) {
            throw new LLMException(ErrorCode.INTERNAL_SERVER_ERROR, e);
        }
    }
}
