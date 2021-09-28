package com.example.springbootcouchdatabasewithfile.mapper;

import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {


      @Mapping(source = "originalFilename", target = "name")
      @Mapping(source = "contentType", target = "type")
      @Mapping(source = "size", target = "size")
      //@Mapping(source = "bytes", target = "data")
      FileInfo fileToFileInfo(MultipartFile file) throws IOException;

}
