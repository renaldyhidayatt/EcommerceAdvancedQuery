package com.sanedge.ecommercequery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "file_uploads")
public class FileUpload extends Timestamped {

    protected String filePath;
    protected String fileName;
    protected String originalFileName;
    protected long fileSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Tag tag;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Category category;

    protected boolean isFeaturedImage;

    public String getUrlPath() {
        if (getFilePath().startsWith("http"))
            return getFilePath();
        else
            return "/api" + getFilePath();
    }
}
