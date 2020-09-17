package io.ambulante.backend.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Function;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Suggestion<T> {
    private T data;
    private String label;

    public static <U> Suggestion<U> of(U data, Function<U, String> accessor) {
        return new Suggestion<>(data, accessor.apply(data));
    }
}
