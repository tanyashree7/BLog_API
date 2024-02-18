package com.codewithtanya.blog.repositories;

import com.codewithtanya.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
