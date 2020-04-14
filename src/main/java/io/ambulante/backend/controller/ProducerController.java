package io.ambulante.backend.controller;

import io.ambulante.backend.mapper.ProducerMapper;
import io.ambulante.backend.model.dto.Producer;
import io.ambulante.backend.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerRepository repository;
    private final ProducerMapper mapper;

    @GetMapping
    public Page<Producer> list(final @PageableDefault Pageable pageable) {
        return repository.findAll(pageable).map(mapper::map);
    }
}
