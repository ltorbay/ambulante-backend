package io.ambulante.backend.controller;

import io.ambulante.backend.mapper.CoordinatesMapper;
import io.ambulante.backend.mapper.ProducerMapper;
import io.ambulante.backend.model.dto.Coordinates;
import io.ambulante.backend.model.dto.Producer;
import io.ambulante.backend.model.exception.NotFoundException;
import io.ambulante.backend.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;
    private final CoordinatesMapper coordinatesMapper;

    @GetMapping
    public Page<Producer> list(final @PageableDefault Pageable pageable) {
        return this.producerRepository.findAll(pageable).map(this.producerMapper::map);
    }

    @PutMapping("/{producerId}/coordinates")
    @Transactional
    public Coordinates updateCoordinates(final @PathVariable("producerId") Integer producerId,
                                         final @RequestBody @Valid Coordinates coordinates) {
        final var producer = this.producerRepository.findById(producerId).orElseThrow(NotFoundException::new);
        producer.setCoordinates(this.coordinatesMapper.map(coordinates));
        return this.coordinatesMapper.map(producer.getCoordinates());
    }

    @GetMapping("/{producerId}/coordinates")
    public Point getCoordinates(final @PathVariable("producerId") Integer producerId,
                                final @RequestBody(required = false) Coordinates coordinates) {
        return new Point(1, 2);
    }

}
