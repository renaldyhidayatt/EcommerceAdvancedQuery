package com.sanedge.ecommercequery.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("2")
public class TagImage extends FileUpload {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    Tag tag;

    boolean isFeaturedImage;
}
