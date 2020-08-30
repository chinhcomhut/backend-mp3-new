package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.CategoryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoryTestRepository extends JpaRepository<CategoryTest, Long> {
}
