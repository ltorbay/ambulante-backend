package io.ambulante.backend.repository;

import io.ambulante.backend.model.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {
}
