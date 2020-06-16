package io.ambulante.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Coordinates {

    @NotNull
    @JsonProperty("latitude")
    private Double x;
    
    @NotNull
    @JsonProperty("longitude")
    private Double y;
}
