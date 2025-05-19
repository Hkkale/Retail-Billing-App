package com.hiten.billing_software.service;

import com.hiten.billing_software.io.CategoryRequest;
import com.hiten.billing_software.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {

     CategoryResponse add(CategoryRequest request, MultipartFile file);

     List<CategoryResponse> read();

     void delete(String categoryId);
}
