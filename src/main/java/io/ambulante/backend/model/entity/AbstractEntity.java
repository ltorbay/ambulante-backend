package io.ambulante.backend.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now(ZoneOffset.UTC);
    }
}
