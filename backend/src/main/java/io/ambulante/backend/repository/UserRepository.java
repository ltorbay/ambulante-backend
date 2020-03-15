package io.ambulante.backend.repository;

import io.ambulante.backend.model.dto.User;
import io.ambulante.backend.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Page<User> findAllProjectedBy(Pageable pageable);
}
