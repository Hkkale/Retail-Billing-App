package com.hiten.billing_software.controller;


import com.hiten.billing_software.io.CategoryRequest;
import com.hiten.billing_software.io.CategoryResponse;
import com.hiten.billing_software.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor

public class CategoryController {


    private final CategoryService categoryService;



    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory( @RequestBody CategoryRequest req){
        return categoryService.add(req);
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
