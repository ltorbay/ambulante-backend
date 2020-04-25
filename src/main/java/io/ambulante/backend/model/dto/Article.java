package io.ambulante.backend.model.dto;

import io.ambulante.backend.model.enums.Unit;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Article {
    private Integer quantity;
    private Unit unit;
    private BigDecimal pricePerUnit;
    private Product product;
    private ImageReference image;
}
