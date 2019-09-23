package org.papaja.blog.mapper;

import org.papaja.blog.dto.CategoryDto;
import org.papaja.blog.entity.Category;
import org.papaja.commons.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryDto, Category> {

    @Override
    public void map(CategoryDto source, Category target) {
        target.setName(source.getName());
    }

    @Override
    public Category get() {
        return new Category();
    }

}
