package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.model.Category;
import com.br.java.carteiradigital.model.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@RequiredArgsConstructor
@Slf4j
@Getter
public class CategoryRequest {

    @NonNull
    private String name;
    @NonNull
    private String tag;

    public Category toModel() {
        log.info("name: "+name+" tag: "+tag);
        boolean tagIsValid = Arrays.stream(Tag.values())
                .anyMatch(c -> tag.equalsIgnoreCase(c.toString()));

        if (!tagIsValid) {
            throw new RuntimeException(tag+" is not a valid values");
        }

        Tag newTag = Tag.valueOf(tag.toUpperCase());
        return new Category(name, newTag);
    }
}
