package io.ambulante.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "presentation_item")
public class PresentationItemEntity extends AbstractEntity {
    private String description;
    private String location;
}
