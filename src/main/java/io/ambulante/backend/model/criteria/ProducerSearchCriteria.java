package io.ambulante.backend.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ambulante.backend.model.dto.Coordinates;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProducerSearchCriteria {
    @NotNull
    private Coordinates center;

    // Range in meters
    private Long range = 10000L;

    @JsonProperty("q")
    private String query;
}
