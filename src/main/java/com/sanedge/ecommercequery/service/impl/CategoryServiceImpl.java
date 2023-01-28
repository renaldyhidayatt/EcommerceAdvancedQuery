package com.sanedge.ecommercequery.service.impl;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanedge.ecommercequery.dto.request.CategoryRequest;
import com.sanedge.ecommercequery.dto.response.MessageResponse;
import com.sanedge.ecommercequery.exception.NotFoundException;
import com.sanedge.ecommercequery.models.Category;
import com.sanedge.ecommercequery.models.Product;
import com.sanedge.ecommercequery.models.Timestamped;
import com.sanedge.ecommercequery.repository.CategoriesRepository;

@Service
public class CategoryServiceImpl {
    private CategoriesRepository categoriesRepository;
    private FileUploadServiceImpl fileUploadServiceImpl;

    @Autowired
    public CategoryServiceImpl(CategoriesRepository categoriesRepository, FileUploadServiceImpl fileUploadServiceImpl) {
        this.categoriesRepository = categoriesRepository;
        this.fileUploadServiceImpl = fileUploadServiceImpl;
    }

    public MessageResponse getByName(String name) {
        Category category = this.categoriesRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("category name not found"));

        return MessageResponse.builder().message("Berhasil mendapatkan data").data(category).statusCode(200).build();
    }

    public MessageResponse findAll() {
        List<Category> categories = this.categoriesRepository.findAll();

        if (categories.isEmpty()) {
            return MessageResponse.builder().message("Categories empty").statusCode(400).build();
        }

        return MessageResponse.builder().message("Berhasil mendapatkan data").data(categories).build();

    }

    public MessageResponse create(CategoryRequest categoryRequest, List<File> files) {
        Category category = new Category();

        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        category.setImages(fileUploadServiceImpl.saveImages(category, files));

        this.categoriesRepository.save(category);

        return MessageResponse.builder().message("Berhasil membuat category").data(category).statusCode(200).build();
    }

    public MessageResponse getAllSummary() {
        List<Category> category = this.categoriesRepository.findAllSummary();

        return MessageResponse.builder().message("Berhasil mendatpakan data").data(category).statusCode(200).build();
    }

    public MessageResponse getRandom() {
        Category category = this.categoriesRepository.getRandom();

        if (category == null) {
            return MessageResponse.builder().message("Berhasil mendapatkan data").statusCode(400).build();
        }

        return MessageResponse.builder().message("Berhasil mendapatkan data").data(category).build();
    }

    public List<Category> getNamesForProducts(List<Product> products) {
        List<Long> ids = products.stream().map(Timestamped::getId).collect(Collectors.toList());
        return getNamesForProductIds(ids);
    }

    public List<Category> getNamesForProductIds(List<Long> productIds) {
        return categoriesRepository.getCategorySummaryFromProducts(productIds);
    }

}
