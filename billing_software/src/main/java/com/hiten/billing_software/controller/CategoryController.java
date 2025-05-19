package com.hiten.billing_software.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiten.billing_software.io.CategoryRequest;
import com.hiten.billing_software.io.CategoryResponse;
import com.hiten.billing_software.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor

public class CategoryController {


    private final CategoryService categoryService;



    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestPart("category") String categoryString,
                                        @RequestPart("file")MultipartFile file){

        ObjectMapper objectMapper= new ObjectMapper();

        CategoryRequest request=null;

        try {
            request= objectMapper.readValue(categoryString,CategoryRequest.class);
            return categoryService.add(request,file);
        }catch (JsonProcessingException ex){

            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Exception occurs while passing the json!");

        }



    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> fetchCategories(){
        return categoryService.read();
    }



    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove( @PathVariable String categoryId){
        try {
            categoryService.delete(categoryId);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
