package com.br.java.carteiradigital.controller.request;

import com.br.java.carteiradigital.config.validation.ApiErrorException;
import com.br.java.carteiradigital.config.validation.UniqueValue;
import com.br.java.carteiradigital.model.Category;
import com.br.java.carteiradigital.model.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;

@RequiredArgsConstructor
@Slf4j
@Getter
public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, field = "label")
    private String name;
    @NotBlank
    private String tag;

    public Category toModel() {
        log.info("name: "+name+" tag: "+tag);
        boolean tagIsValid = Arrays.stream(Tag.values())
                .anyMatch(c -> tag.equalsIgnoreCase(c.toString()));

        if (!tagIsValid) {
            throw new ApiErrorException("tag",tag+" is not a valid value", HttpStatus.BAD_REQUEST);
        }

        Tag newTag = Tag.valueOf(tag.toUpperCase());
        return new Category(name, newTag);
    }
}
