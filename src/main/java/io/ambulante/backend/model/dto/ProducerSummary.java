package io.ambulante.backend.model.dto;

import lombok.Data;

@Data
public class ProducerSummary {
    private Integer id;
    private Coordinates coordinates;
    private String name;
}
