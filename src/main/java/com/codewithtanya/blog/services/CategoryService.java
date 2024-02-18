package com.codewithtanya.blog.services;

import com.codewithtanya.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
 void deleteCategory(Integer categoryId);

 //get single id
    CategoryDto getCategory(Integer categoryId);

    //get all values

    List<CategoryDto> getCategories();
}
