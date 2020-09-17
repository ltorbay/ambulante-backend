package io.ambulante.backend.mapper;

import io.ambulante.backend.configuration.DefaultMapperConfiguration;
import io.ambulante.backend.model.dto.Product;
import io.ambulante.backend.model.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfiguration.class)
public interface ProductMapper extends BaseMapper<Product, ProductEntity> {
}
