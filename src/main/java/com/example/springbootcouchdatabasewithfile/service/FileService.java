package com.example.springbootcouchdatabasewithfile.service;


import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface FileService {
    FileInfo uploadFile(MultipartFile file) throws IOException;

    Optional<FileInfo> getFile(String id);


   List<FileInfo> getFiles();

    void deleteFile(String id);

}
