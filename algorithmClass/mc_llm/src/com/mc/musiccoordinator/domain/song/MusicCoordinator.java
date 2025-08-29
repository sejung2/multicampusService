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
    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public Optional<Song> recommend(String prompt) {

        try {
            prompt += ". 이 감정에 어울리는 노래를 1곡 추천해줘. 이유도 함께 알려줘.";
            BaseModel model = context.initChatModel(API_URL, LLMProvider.GEMINI);
            BaseResponse response = model.invoke(new GeminiRequest<SongFormat>(prompt, SongFormat.INSTANCE));
            Song song = Song.fromMap(response.messageToMap().getFirst());

            String qrCodeText = "https://www.youtube.com/results?search_query=" + song.artist() + "-" + song.name();
            qrCodeText = URLEncoder.encode(qrCodeText, "UTF-8");

            QrCodeGenerator generator = new QrCodeGenerator();
            QrCodeDTO dto = new QrCodeDTO(qrCodeText, song.name());
            generator.generate(dto);

            return Optional.of(song);
        }catch (LLMException e) {
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
