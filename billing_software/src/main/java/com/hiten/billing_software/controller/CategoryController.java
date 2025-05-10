package com.hiten.billing_software.controller;


import com.hiten.billing_software.io.CategoryRequest;
import com.hiten.billing_software.io.CategoryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping()
    public CategoryResponse addCategory( @RequestBody CategoryRequest req){
        return null;
    }
}
