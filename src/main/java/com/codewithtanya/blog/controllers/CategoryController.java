package com.codewithtanya.blog.controllers;

import com.codewithtanya.blog.payloads.ApiResponse;
import com.codewithtanya.blog.payloads.CategoryDto;
import com.codewithtanya.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    // create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory=categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }
//update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto categoryDto1=categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }
//delete

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("message deleted successfully",true),HttpStatus.OK);
    }
    //get single user
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
       CategoryDto getCategory= categoryService.getCategory(categoryId);
        return new ResponseEntity<>(getCategory,HttpStatus.OK);

    }

    //get all categories

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> getCategories=categoryService.getCategories();
        return new ResponseEntity<>(getCategories,HttpStatus.OK);
    }
}
