package io.ambulante.backend.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProducerSearchCriteria {
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    // Range in meters
    private Long range = 10000L;

    @JsonProperty("q")
    private String query;
}
