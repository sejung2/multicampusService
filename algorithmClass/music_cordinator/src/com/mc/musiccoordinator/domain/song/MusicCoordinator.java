package com.mc.musiccoordinator.domain.song;

import com.google.zxing.WriterException;
import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.LLMContext;
import com.mc.musiccoordinator.infra.llm.LLMProvider;
import com.mc.musiccoordinator.infra.llm.exception.LLMException;
import com.mc.musiccoordinator.infra.llm.gemini.chat.GeminiRequest;
import com.mc.musiccoordinator.infra.qrcode.QrCodeGenerator;
import com.mc.musiccoordinator.infra.qrcode.dto.QrCodeDTO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

public class MusicCoordinator {

    private LLMContext context = new LLMContext();
    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";

    public Optional<Song> recommend(String prompt) {

        try {
            prompt += ". 이 감정에 어울리는 노래를 1곡 추천해줘. 이유도 함께 알려줘.";
            BaseModel model = context.initChatModel(API_URL, LLMProvider.GEMINI);
            BaseResponse response = model.invoke(new GeminiRequest<SongFormat>(prompt, SongFormat.INSTANCE));
            Song song = Song.fromMap(response.messageToMap().getFirst());

            // 1. 유튜브 검색을 위한 기본 URL
            String youtubeBaseUrl = "https://www.youtube.com/results?search_query=";

            // 2. 검색어로 사용할 텍스트 (가수 + 노래 제목)
            String searchTerm = song.artist() + " " + song.name();

            // 3. 검색어만 UTF-8로 인코딩
            String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");

            // 4. 기본 URL과 인코딩된 검색어를 합쳐 최종 링크 생성
            String finalUrl = youtubeBaseUrl + encodedSearchTerm;

            QrCodeGenerator generator = new QrCodeGenerator();
            // DTO의 text에는 최종적으로 완성된 URL을, fileName에는 노래 제목을 전달
            QrCodeDTO dto = new QrCodeDTO(finalUrl, song.name());
            generator.generate(dto);

            return Optional.of(song);
        } catch (LLMException e) {
            // e.printStackTrace();
            System.out.println(e.code().message());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return Optional.empty();


    }

}
