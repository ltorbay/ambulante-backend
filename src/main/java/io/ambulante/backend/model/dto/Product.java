package io.ambulante.backend.model.dto;

import io.ambulante.backend.model.enums.Unit;
import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private ImageReference defaultImage;
    private Unit defaultUnit;
}
