package io.ambulante.backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class Producer {
    private String name;
    private List<Article> articles;
    private List<PresentationItem> presentationList;

    private Coordinates coordinates;
}
