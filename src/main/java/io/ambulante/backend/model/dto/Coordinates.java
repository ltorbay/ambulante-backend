package io.ambulante.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Coordinates {

    @NonNull
    @JsonProperty("latitude")
    private Double x;

    @NonNull
    @JsonProperty("longitude")
    private Double y;
}
