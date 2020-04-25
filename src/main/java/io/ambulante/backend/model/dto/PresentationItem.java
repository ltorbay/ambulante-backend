package io.ambulante.backend.model.dto;

import io.ambulante.backend.model.entity.AbstractEntity;
import lombok.Data;

@Data
public class PresentationItem {
    private Integer id;
    private String description;
    private String location;
}
