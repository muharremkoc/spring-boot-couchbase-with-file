package com.example.springbootcouchdatabasewithfile.controller;

import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import com.example.springbootcouchdatabasewithfile.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/couchbase")
public class FileController {

   final FileService fileService;

    @PostMapping(path = "/uploadFile", consumes = {"multipart/form-data"})
    public FileInfo uploadFile(@RequestPart MultipartFile file) throws IOException {
        return fileService.uploadFile(file);
    }

    @GetMapping("/files")
     public List<FileInfo> getFiles(){
        return fileService.getFiles();
    }
    @GetMapping("/file/{id}")
    public FileInfo getFile(@PathVariable("id") String id){
        return fileService.getFile(id).get();
    }

    @DeleteMapping("/file/{id}")
    public void deleteFile(@PathVariable("id")String id){
        fileService.deleteFile(id);
    }
}
