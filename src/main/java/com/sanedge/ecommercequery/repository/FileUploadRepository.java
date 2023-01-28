package com.sanedge.ecommercequery.repository;

import com.sanedge.ecommercequery.models.FileUpload;
import com.sanedge.ecommercequery.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
    @Query("select f.filePath from FileUpload f where f.product.id in :productIds")
    List<ProductImage> findAllWhereProductIdIn(List<Long> productIds);
}
