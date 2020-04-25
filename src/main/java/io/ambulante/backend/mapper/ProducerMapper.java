package io.ambulante.backend.mapper;

import io.ambulante.backend.model.dto.Producer;
import io.ambulante.backend.model.entity.ProducerEntity;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface ProducerMapper {
    Producer map(final ProducerEntity producerEntity);

    ProducerEntity map(final Producer producer);
}
