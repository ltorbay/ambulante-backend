package io.ambulante.backend.repository;

import io.ambulante.backend.model.entity.ProducerEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {
    @Query(nativeQuery = true,
            value = "select p.* from producer p " +
//                    "where ST_DWITHIN(coordinates, ST_SetSRID(ST_MakePoint(44.213320, 2.071622), 4326), 1000, true)")
                    "where ST_DWITHIN(coordinates, ST_SetSRID(:center, 4326), :range, true) " +
                    "and p.name ilike :query")
    Page<ProducerEntity> findProducer(final Point center, long range, String query, Pageable pageable);
}
