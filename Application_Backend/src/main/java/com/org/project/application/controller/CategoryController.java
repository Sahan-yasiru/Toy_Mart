package com.org.project.application.controller;

import com.org.project.application.dto.DtoCategory;
import com.org.project.application.service.custom.CategoryService;
import com.org.project.application.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<APIResponse<List<DtoCategory>>> getAllCategorys() throws Exception {
        List<DtoCategory> categories= categoryService.getAll();
        return ResponseEntity.ok(
                new APIResponse<>(200, "Categorys fetched successfully", categories)
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<DtoCategory>> getCategoryByID(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new APIResponse<>(200,"Category found",categoryService.find(id)),HttpStatus.ACCEPTED);
    }


    @PostMapping
    public ResponseEntity<APIResponse<DtoCategory>> createCategory(@RequestBody DtoCategory dtoCategory) throws Exception {
         return new ResponseEntity<>(new APIResponse<>(201,"Category saved",categoryService.save(dtoCategory)),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<APIResponse<DtoCategory>> updateCategory(@RequestBody DtoCategory dtoCategory) throws Exception {
        return ResponseEntity.ok(
                new APIResponse<>(200, "Category updated successfully", categoryService.update(dtoCategory))
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteCategory(@PathVariable String id) throws Exception {
         categoryService.delete(id);
         return  ResponseEntity.ok(
                 new APIResponse<>(200,"Category deleted successfully",null)
         );
    }
}