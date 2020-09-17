package io.ambulante.backend.mapper;

import io.ambulante.backend.configuration.DefaultMapperConfiguration;
import io.ambulante.backend.model.dto.Coordinates;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(config = DefaultMapperConfiguration.class, uses = GeometryFactory.class)
public abstract class CoordinatesMapper {
    @Autowired
    private GeometryFactory geometryFactory;

    public abstract Coordinates map(final Point producerEntity);

    public Point map(final Coordinates coordinates) {
        if (coordinates == null) {
            return null;
        }
        return this.geometryFactory.createPoint(new Coordinate(coordinates.getX(), coordinates.getY()));
    }
}
