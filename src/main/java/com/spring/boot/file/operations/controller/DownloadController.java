package com.spring.boot.file.operations.controller;

import com.spring.boot.file.operations.model.Photo;
import com.spring.boot.file.operations.service.PhotoSertvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    @Autowired
    private PhotoSertvice photoSertvice;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable final String id) {
        System.out.println("**** Download Controlled Called..!! ****");
        Photo photo = photoSertvice.getPhoto(id);
        if (null == photo) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition contentType = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(contentType);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
