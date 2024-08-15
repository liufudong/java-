package com.example.fileupload.controller;

import com.example.fileupload.dao.FileInfoRepository;
import com.example.fileupload.pojo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 文件上传
 */
@RestController
public class FileUploadController {

//    private static final String UPLOAD_DIR = "uploads/";
private static final String UPLOAD_DIR = "D:/java/apache-tomcat-8.5.35-windows-x64/apache-tomcat-tempdir/";

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("fileName") String fileName) {
        if (file.isEmpty()) {
            return "No file selected";
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            if (!uploadDir.mkdirs()) {
                return "Failed to create upload directory";
            }
        }

        try {
            System.out.println("====="+uploadDir+"===="+file.getOriginalFilename());
            File fileToSave = new File(uploadDir, fileName);
            file.transferTo(fileToSave);

            FileInfo fileInfo = new FileInfo();
            fileInfo.setFilename(fileName);
            fileInfo.setUploadTime(LocalDateTime.now());
            fileInfo.setFilePath(fileToSave.getAbsolutePath());
            fileInfoRepository.save(fileInfo);

            return "File uploaded and information saved successfully: " + file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}
