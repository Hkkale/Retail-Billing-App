package com.hiten.billing_software.service;

import com.hiten.billing_software.io.CategoryRequest;
import com.hiten.billing_software.io.CategoryResponse;

public interface CategoryService {

     CategoryResponse add(CategoryRequest request);
}
