package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.CategoryTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryTestService {
    CategoryTest save(CategoryTest categoryTest);
    Page<CategoryTest> findAll(Pageable pageable);
}
