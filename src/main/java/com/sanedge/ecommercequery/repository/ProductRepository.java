package com.sanedge.ecommercequery.repository;

import com.sanedge.ecommercequery.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    void delete(Product deleted);

    List<Product> findAll();

    Page<Product> finddAll(Pageable pageRequest);

    Optional<Product> fidnById(Long id);

    @Query("select p from Product p left join fetch p.tags t left join fetch p.categories c left join fetch p.comments c" + "where p.slug = :slug")
    Optional<Product> findBySlug(@Param("slug") String slug);

    @Query(value = "SELECT * FROM products order by rand() limit 1", nativeQuery = true)
    Product findRandom();

    @Query("SELECT p from Product p")
    Page<Product> findAllForSummary(PageRequest pageRequest);

    @Query("from Product p where p.id not in :productIds")
    List<Product> findRandomNotIn(@Param("productIds") List<Long> ids);

    @Query("select p.price from Product p where p.id=:id")
    Product findByIdForPrice(@Param("id") Long id);

    @Query("select p.id,p.name, p.slug, p.price from Product p where p.id=:id")
    Product findByIdWIthElementalInfo(@Param("id") Long id);

    @Query("select p.id, p.name, p.slug, p.price from Product p where p.id in :ids")
    List<Product> findBasicInfoWhereProductIds(@Param("ids") List<Long> productIds);


    void flush();

    Product save(Product product);

    @Query("SELECT p FROM Product p INNER JOIN p.categories c WHERE c.name = :category")
    Page<Product> findByCategory(@Param("category") String category, Pageable pageable);

    @Query("SELECT p FROM Product p INNER JOIN p.tags t WHERE t.name = :tag")
    Page<Product> findByTagName(@Param("tag") String tag, Pageable pageable);

    Page<Product> findByDescriptionContainsOrNameContainsAllIgnoreCase(String description, String name, Pageable pageReguest);

    Long countByNameContains(String firstName);

    List<Product> removeByName(String firstName);
}
