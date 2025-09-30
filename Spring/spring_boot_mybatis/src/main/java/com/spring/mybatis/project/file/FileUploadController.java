package com.spring.mybatis.project.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class FileUploadController {

    @GetMapping("fileUploadForm")
    public String viewUploadForm() {
        return "upload/fileUploadForm";
    }

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
        // 1. 파일 저장 경로 설정
        String uploadPath = "C:/Users/USER/myWork/multicampus/upload/";

        // 2. 전송된 원본 파일 이름 저장
        String originalFileName = file.getOriginalFilename(); // 전송된 파일명 추출

        // 3. 중복되지 않는 파일 이름으로 변경
        // 서버에 저장되는 파일 이름: UUID 사용
        UUID uuid = UUID.randomUUID();
        String saveFileName = uuid.toString() + "_" + originalFileName;

        // 4. 저장을 위한 파일 객체 생성(저장경로를 포함한 파일명으로 객체 생성)
        File sendFile = new File(uploadPath + saveFileName);

        // 5. 시스템 내 저장 공간으로 파일 전송
        file.transferTo(sendFile); // 실제로 파일이 저장되는 부분

        // 클라이언트에게 전송한 파일의 결과를 모델에 저장
        model.addAttribute("originalFileName", originalFileName);

        return "upload/fileUploadResult";
    }

    // 여러 파일 업로드: 여러 파일의 정보 파라미터 전달 ArrayList
    @PostMapping("/fileUploadMultiple")
    public String fileUploadMultiple(@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files, Model model) throws IOException {

        // 1. 파일 저장 경로 설정 - 디렉터리 마지막에 / 있어야함
        String uploadPath = "C:/Users/USER/myWork/multicampus/upload/";

        // 2. 원본 파일명 추출: 여러개를 저장할 수 있는 변수
        ArrayList<String> originalFileNameList = new ArrayList<>();

        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            originalFileNameList.add(originalFileName);

            UUID uuid = UUID.randomUUID();
            String saveFileName = uuid.toString() + "_" + originalFileName;

            File sendFile = new File(uploadPath + saveFileName);

            file.transferTo(sendFile);
        }

        model.addAttribute("originalFileNameList", originalFileNameList);
        return "upload/fileUploadMultipleResult";
    }

    // 파일이름 변경하지 않고 파일 업로드
    @PostMapping("/fileOriginalNameUpload")
    public String fileOriginalNameUpload(@RequestParam("uploadFileOriginal") MultipartFile file, Model model) throws IOException {
        String uploadPath = "C:/Users/USER/myWork/multicampus/upload/product_image/";
        String originalFileName = file.getOriginalFilename();
        File sendFile = new File(uploadPath + originalFileName);
        file.transferTo(sendFile);

        model.addAttribute("originalFileName", originalFileName);
        return "upload/fileUploadResult";
    }

    // ----------------------------------------
    // 비동기 요청 처리

    @GetMapping("/imageFileUploadForm")
    public String imageFileUploadForm() {
        return "upload/imageFileUploadForm";
    }

    @ResponseBody
    @PostMapping("/imageFileUpload")
    public String imageFileUpload(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        String uploadPath = "C:/Users/USER/myWork/multicampus/upload/";
        String originalFileName = file.getOriginalFilename();
        File sendFile = new File(uploadPath + originalFileName);
        file.transferTo(sendFile);

        return "success";
    }
}
