package com.sanedge.ecommercequery.repository;

import com.sanedge.ecommercequery.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    @Query("select c from Category c left join fetch c.images i")
    List<Category> findAllSummary();

    @Query(value = "SELECT * FROM categories order by rand() limit 1", nativeQuery = true)
    Category getRandom();

    @Query("select c from Category c inner join c.products as p where p.id in :ids")
    List<Category> getCategorySummaryFromProducts(@Param("ids") List<Long> productIds);

}
