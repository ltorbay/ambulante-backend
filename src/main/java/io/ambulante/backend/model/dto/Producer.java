package io.ambulante.backend.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Producer extends ProducerSummary {
    private List<Article> articles;
    private List<PresentationItem> presentationList;
}
