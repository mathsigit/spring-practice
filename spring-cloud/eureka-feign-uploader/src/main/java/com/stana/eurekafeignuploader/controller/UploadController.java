package com.stana.eurekafeignuploader.controller;

import com.stana.eurekafeignuploader.client.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/uploadfile")
    public String dc(@RequestParam("file") MultipartFile multi) {
        return uploadService.handleFileUpload(multi);
    }
}
