package study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import study.entit.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
public class ImprotAndExport {

    @PostMapping("/import")
    public String add(MultipartFile multipartFile)  {
        String s = "";
        if (multipartFile == null) {
           s = "no file upload";
        } else {
            InputStream inputStream = null;
            ByteArrayOutputStream  bos = null;
            try {
                inputStream = multipartFile.getInputStream();
                bos = new ByteArrayOutputStream();
                FileUtils.write(inputStream,bos);
                String data = new String(bos.toByteArray());
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                FileUtils.close(inputStream,bos);
            }
        }
        return s;
    }

    @GetMapping("/export")
    public String export(String date, HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        String s = "";
        String fileName = "test.txt";

        String data = "abcd";
        OutputStream os = null;
        InputStream ins = null;
        try {
            // 设置文件返回值格式及响应消息头
            os = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            ins = new ByteArrayInputStream(data.getBytes());
            FileUtils.write(ins,os);
        } catch (IOException e) {
            response.setContentType("application/json");
            response.setHeader("content-type", "application/json");
            //log.error(e.getMessage());
            s = "下载异常";
        }finally {
            FileUtils.close(ins,os);
        }
        return s;
    }

}
