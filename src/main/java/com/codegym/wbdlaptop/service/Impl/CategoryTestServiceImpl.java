package com.codegym.wbdlaptop.service.Impl;

import com.codegym.wbdlaptop.model.CategoryTest;
import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.repository.ICategoryTestRepository;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.ICategoryTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryTestServiceImpl implements ICategoryTestService {
    @Autowired
    ICategoryTestRepository categoryTestRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    public CategoryTest save(CategoryTest categoryTest) {
        User user = userDetailsService.getCurrentUser();
        categoryTest.setUser(user);
        return categoryTestRepository.save(categoryTest);
    }

    @Override
    public Page<CategoryTest> findAll(Pageable pageable) {
        return categoryTestRepository.findAll(pageable);
    }
}
