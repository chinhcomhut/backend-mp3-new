package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.CategoryTest;
import com.codegym.wbdlaptop.service.Impl.CategoryTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class CategoryTestAPI {
    @Autowired
    CategoryTestServiceImpl categoryTestService;
    @PostMapping("/categorytest")
    public ResponseEntity<?> createCategoryTest(@Valid @RequestBody CategoryTest categoryTest){
        categoryTestService.save(categoryTest);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @GetMapping("/categorytest")
    public ResponseEntity<?> pageCategoryTest(@PageableDefault(sort = "nameCategoryTest", direction = Sort.Direction.ASC)Pageable pageable){
        Page<CategoryTest> categoryTests = categoryTestService.findAll(pageable);
        if(categoryTests.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryTests,HttpStatus.OK);
    }
}
