package io.ambulante.backend.repository;

import io.ambulante.backend.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Page<ProductEntity> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);
}
