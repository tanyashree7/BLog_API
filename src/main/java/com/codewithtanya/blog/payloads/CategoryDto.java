package com.codewithtanya.blog.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private int categoryId;
    @NotBlank
    @Size(min=1)
    private String categoryTitle;

    @NotBlank
    @Size(min=3)
    private String categoryDescription;
}
