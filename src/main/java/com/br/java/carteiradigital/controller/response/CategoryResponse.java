package com.br.java.carteiradigital.controller.response;

import com.br.java.carteiradigital.model.Category;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Slf4j
public class CategoryResponse {

    @NonNull
    private String name;
    @NonNull
    private Long id;
    @NonNull
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
