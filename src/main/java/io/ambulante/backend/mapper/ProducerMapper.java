package io.ambulante.backend.mapper;

import io.ambulante.backend.configuration.DefaultMapperConfiguration;
import io.ambulante.backend.model.dto.Producer;
import io.ambulante.backend.model.dto.ProducerSummary;
import io.ambulante.backend.model.entity.ProducerEntity;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfiguration.class, uses = CoordinatesMapper.class)
public interface ProducerMapper extends BaseMapper<Producer, ProducerEntity> {
    ProducerSummary toSummary(final ProducerEntity producerEntity);
}
