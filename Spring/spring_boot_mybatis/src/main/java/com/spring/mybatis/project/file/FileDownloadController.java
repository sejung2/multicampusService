package com.spring.mybatis.project.file;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileDownloadController {

    @GetMapping("/fileDownloadList")
    public String fileDownloadList(Model model) {

        File path = new File("C:/Users/USER/myWork/multicampus/upload/");
        String[] fileList = path.list();

        model.addAttribute("fileList", fileList);
        return "upload/fileDownloadList";
    }

    // 다운로드 요청처리
    @GetMapping("/fileDownload/{file}")
    public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException {
        // 파일 객체 생성(서버내에서 사용)
        File f = new File("C:/Users/USER/myWork/multicampus/upload/", file);

        // 한글파일명 경우 인코딩
        String encodedFileName = new String(file.getBytes("UTF-8"), "ISO-8859-1");

        // response 객체 헤더 구성(파일 정보)
        response.setContentType("application/download");
        response.setContentLength((int) f.length()); // 파일 크기
        response.setHeader("Content-Disposition",
                "attatchment;filename=\"" + encodedFileName + "\"");

        // 파일 다운로드 처리(file i/o stream을 통해서 FileCopyUtils.copy() 사용
        FileInputStream fis = new FileInputStream(f);
        OutputStream os = response.getOutputStream();

        // 파일 다운로드
        FileCopyUtils.copy(fis, os);

    }
}
