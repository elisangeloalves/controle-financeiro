package com.br.java.carteiradigital.controller.response;

import com.br.java.carteiradigital.model.Category;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Slf4j
public class CategoryResponse {

    @NotBlank
    private String name;
    @NotNull
    private Long id;
    @NotBlank
    private String tag;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.tag = category.getTag().toString();
    }

    public static List<CategoryResponse> listCategories(List<Category> categoryList) {
        return categoryList.stream().map(CategoryResponse::new).toList();
    }
}
