package io.ambulante.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Coordinates {

    @NotNull
    @JsonProperty("latitude")
    private Double x;
    
    @NotNull
    @JsonProperty("longitude")
    private Double y;
}
