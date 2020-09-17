package io.ambulante.backend.controller;

import io.ambulante.backend.mapper.ProductMapper;
import io.ambulante.backend.model.dto.Product;
import io.ambulante.backend.model.dto.Suggestion;
import io.ambulante.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/suggest")
    @Cacheable(value = "articleSuggestion", key = "{#query, #pageable.pageSize, #pageable.pageNumber}")
    public Page<Suggestion<Product>> suggestArticles(@RequestParam("q") String query,
                                                     @PageableDefault Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCaseOrderByName(query, pageable)
                                .map(productMapper::map)
                                .map(p -> Suggestion.of(p, Product::getName));
    }
}
