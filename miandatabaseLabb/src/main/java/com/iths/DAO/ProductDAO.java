package com.iths.DAO;

import com.iths.domain.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product WHERE " +
            "(:name IS NULL OR name = :name) AND " +
            "(:category IS NULL OR category = :category) " +
            "ORDER BY " +
            "CASE WHEN :sortOrder = 'asc' THEN price END ASC, " +
            "CASE WHEN :sortOrder = 'desc' THEN price END DESC",
            nativeQuery = true)
    List<Product> findProducts(@Param("name") String name,
                               @Param("category") String category,
                               @Param("sortOrder") String sortOrder);

}
