package com.codewithtanya.blog.services.impl;

import com.codewithtanya.blog.entities.Category;
import com.codewithtanya.blog.exceptions.ResourceNotFoundException;
import com.codewithtanya.blog.payloads.CategoryDto;
import com.codewithtanya.blog.repositories.CategoryRepo;
import com.codewithtanya.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat=modelMapper.map(categoryDto,Category.class);
       Category addedCat= categoryRepo.save(cat);

        return modelMapper.map(addedCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat=categoryRepo.findById(categoryId).orElseThrow(() -> new
                ResourceNotFoundException("Category","CategoryId",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
Category updatedcat=this.categoryRepo.save(cat);
        return modelMapper.map(updatedcat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
Category cat = categoryRepo.findById(categoryId).orElseThrow(()->
        new ResourceNotFoundException("Category","category Id",categoryId));
 categoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat=categoryRepo.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","Category Id",categoryId));

        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories=categoryRepo.findAll();
List<CategoryDto> catDtos=categories.stream().map((cat)->modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
