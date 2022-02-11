package io.ambulante.backend.controller;

import io.ambulante.backend.mapper.CoordinatesMapper;
import io.ambulante.backend.mapper.ProducerMapper;
import io.ambulante.backend.model.criteria.ProducerSearchCriteria;
import io.ambulante.backend.model.dto.Coordinates;
import io.ambulante.backend.model.dto.Producer;
import io.ambulante.backend.model.dto.ProducerSummary;
import io.ambulante.backend.model.dto.Suggestion;
import io.ambulante.backend.model.exception.NotFoundException;
import io.ambulante.backend.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;
    private final CoordinatesMapper coordinatesMapper;

    @GetMapping
    public Page<ProducerSummary> list(final @PageableDefault Pageable pageable) {
        return this.producerRepository.findAll(pageable).map(this.producerMapper::toSummary);
    }

    @GetMapping("/{producerId}")
    public Producer get(final @PathVariable("producerId") Integer producerId) {
        return this.producerRepository
                .findById(producerId)
                .map(this.producerMapper::map)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{producerId}/coordinates")
    @Transactional
    public Coordinates updateCoordinates(final @PathVariable("producerId") Integer producerId,
                                         final @RequestBody @Validated Coordinates coordinates) {
        final var producer = this.producerRepository.findById(producerId).orElseThrow(NotFoundException::new);
        producer.setCoordinates(this.coordinatesMapper.map(coordinates));
        return this.coordinatesMapper.map(producer.getCoordinates());
    }

    @GetMapping("/search")
    public Page<ProducerSummary> search(final @ModelAttribute ProducerSearchCriteria criteria,
                                        final @PageableDefault Pageable pageable) {
        return this.producerRepository.findProducer(this.coordinatesMapper.map(Coordinates.builder()
                                                                                          .x(criteria.getLatitude())
                                                                                          .y(criteria.getLongitude())
                                                                                          .build()),
                                                    criteria.getRange(),
                                                    String.format("%%%s%%", Optional.ofNullable(criteria.getQ()).orElse("")),
                                                    pageable).map(this.producerMapper::toSummary);
    }

    @GetMapping("/suggest")
    @Cacheable(value = "producerSuggestion", key = "{#query, #pageable.pageSize, #pageable.pageNumber}")
    public Page<Suggestion<Producer>> suggestProducers(@RequestParam("q") String query,
                                                      @PageableDefault Pageable pageable) {
        return producerRepository.findByNameContainingIgnoreCaseOrderByName(query, pageable)
                                 .map(producerMapper::map)
                                 .map(p -> Suggestion.of(p, Producer::getName));
    }
}
