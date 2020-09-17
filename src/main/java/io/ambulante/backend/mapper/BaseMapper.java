package io.ambulante.backend.mapper;

import io.ambulante.backend.model.entity.AbstractEntity;

public interface BaseMapper<DTO, ENT extends AbstractEntity> {
    DTO map(final ENT producerEntity);

    ENT map(final DTO producer);
}
