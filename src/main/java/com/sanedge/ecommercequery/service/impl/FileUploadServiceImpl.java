package com.sanedge.ecommercequery.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanedge.ecommercequery.models.Category;
import com.sanedge.ecommercequery.models.CategoryImage;
import com.sanedge.ecommercequery.models.FileUpload;
import com.sanedge.ecommercequery.models.Product;
import com.sanedge.ecommercequery.models.ProductImage;
import com.sanedge.ecommercequery.models.Tag;
import com.sanedge.ecommercequery.models.TagImage;
import com.sanedge.ecommercequery.repository.FileUploadRepository;

@Service
public class FileUploadServiceImpl {
    @Autowired
    private FileUploadRepository fileUploadRepository;

    public List<CategoryImage> saveImages(Category category, List<File> filesInput) {
        List<CategoryImage> files = new ArrayList<>();
        for (int i = 0; i < filesInput.size(); i++) {
            File fi = filesInput.get(i);
            CategoryImage pi = new CategoryImage();
            pi.setCategory(category);
            setBasicInfo(pi, fi);

            if (i == 0)
                pi.setFeaturedImage(true);

            files.add(pi);
        }

        // fileUploadRepository.saveAll(files);
        return files;
    }

    public Collection<ProductImage> saveImages(Product product, List<File> filesInput) {
        List<ProductImage> files = new ArrayList<>();
        for (int i = 0; i < filesInput.size(); i++) {
            File fi = filesInput.get(i);
            ProductImage pi = new ProductImage();
            pi.setProduct(product);
            setBasicInfo(pi, fi);

            if (i == 0)
                pi.setFeaturedImage(true);

            files.add(pi);
        }

        // fileUploadRepository.saveAll(files);
        return files;
    }

    public List<TagImage> saveImages(Tag tag, List<File> filesInput) {
        List<TagImage> files = new ArrayList<>();
        for (int i = 0; i < filesInput.size(); i++) {
            File fi = filesInput.get(i);
            TagImage pi = new TagImage();
            pi.setTag(tag);
            setBasicInfo(pi, fi);

            if (i == 0)
                pi.setFeaturedImage(true);

            files.add(pi);
        }
        return files;
    }

    public FileUpload setBasicInfo(FileUpload fileUpload, File file) {
        fileUpload.setFileName(file.getName());
        fileUpload.setOriginalFileName(file.getName());
        fileUpload.setFileSize(file.length());
        fileUpload.setFilePath(
                file.getAbsolutePath().replace(new File("uploads").getAbsolutePath(), "").replace("\\", "/"));
        return fileUpload;
    }

    public void save(FileUpload fu) {
        fileUploadRepository.save(fu);
    }

    public List<ProductImage> getProductImagesFrom(List<Long> productIds) {
        return fileUploadRepository.findAllWhereProductIdIn(productIds);
    }
}
