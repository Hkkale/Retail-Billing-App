package com.hiten.billing_software.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
public class FileServiceImpl {


    @Value("${project.image}")
    private String path;

    public String uploadImage(MultipartFile file){
        String name=file.getOriginalFilename();

        String filePath=path+ File.separator+name;

        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filePath;

    }

    public void delete(String url){

        File file = new File(url);

        if(file.delete()){
            System.out.println("File Deleted sucessfully"+file.getName());
        }
        else{
            System.out.println("error in  Deleting file"+file.getName());
        }





    }


}
