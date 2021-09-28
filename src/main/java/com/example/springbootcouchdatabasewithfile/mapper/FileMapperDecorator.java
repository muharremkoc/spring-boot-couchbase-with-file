package com.example.springbootcouchdatabasewithfile.mapper;


import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileMapperDecorator implements FileMapper{

    @Setter(onMethod = @__({@Autowired}))
    FileMapper fileMapper;

    @Override
    public FileInfo fileToFileInfo(MultipartFile file) throws IOException {
        FileInfo fileInfo=fileMapper.fileToFileInfo(file);
         //String fileDataAsString=Base64.getEncoder().encodeToString(file.getBytes());
           //  fileInfo.setData(fileDataAsString);
        byte[] files=file.getBytes();

        fileInfo.setData(new String(files));
        return fileInfo;
    }


}











