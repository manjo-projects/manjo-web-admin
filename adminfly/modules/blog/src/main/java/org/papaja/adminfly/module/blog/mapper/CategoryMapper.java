package org.papaja.adminfly.module.blog.mapper;

import org.papaja.adminfly.commons.dao.mapper.AbstractMapper;
import org.papaja.adminfly.module.blog.dto.CategoryDto;
import org.papaja.adminfly.module.blog.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends AbstractMapper<CategoryDto, Category> {

    @Override
    public void accept(CategoryDto source, Category target) {
        target.setName(source.getName());
    }

    @Override
    public Category get() {
        return new Category();
    }

}
