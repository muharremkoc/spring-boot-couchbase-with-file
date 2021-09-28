package com.example.springbootcouchdatabasewithfile.service;


import com.example.springbootcouchdatabasewithfile.mapper.FileMapper;
import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import com.example.springbootcouchdatabasewithfile.repository.FileRepository;
import com.fasterxml.jackson.databind.util.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileServiceImpl implements FileService{



    final FileMapper fileMapper;
    final FileRepository fileRepository;


    @Override
    public FileInfo uploadFile(MultipartFile file) throws IOException {



        FileInfo fileInfo= fileMapper.fileToFileInfo(file);

       // byte[] files=file.getBytes();

        //fileInfo.setData(new String(files));


        return fileRepository.save(fileInfo);

    }

    @Override
    public Optional<FileInfo> getFile(String id) {



        return fileRepository.findById(id);
    }

    @Override
    public List<FileInfo> getFiles() {
        return fileRepository.findAll();
    }



    @Override
    public void deleteFile(String id) {

           fileRepository.deleteById(id);
    }
}
