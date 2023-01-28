package com.sanedge.ecommercequery.repository;

import com.sanedge.ecommercequery.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);

    Tag findByNameIgnoreCase(String name);

    @Query("select t from Tag t left join fetch t.images i")
    List<Tag> findAll();

    @Query("select t.id, t.name from Tag t inner join t.products as p where p.id in :ids")
    List<Object[]> getTagSummaryFromProducts(@Param("ids") Collection<Long> ids);
}
