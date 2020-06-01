package io.ambulante.backend.model.dto;

import lombok.Data;
import org.springframework.data.geo.Point;

import java.util.List;

@Data
public class Producer {
    private String name;
    private List<Article> articles;
    private List<PresentationItem> presentationList;

    private Point coordinates;
}
