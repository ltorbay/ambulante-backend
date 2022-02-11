package io.ambulante.backend.model.criteria;

import lombok.Data;
import lombok.NonNull;

@Data
public class ProducerSearchCriteria {
    @NonNull
    private Double latitude;

    @NonNull
    private Double longitude;

    // Range in meters
    private Long range = 10000L;

    private String q;
}
