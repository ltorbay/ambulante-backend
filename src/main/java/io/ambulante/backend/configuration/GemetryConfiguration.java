package io.ambulante.backend.configuration;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GemetryConfiguration {
    @Bean
    GeometryFactory geometryFactory() {
        return new GeometryFactory(new PrecisionModel(), 4326);
    }
}
