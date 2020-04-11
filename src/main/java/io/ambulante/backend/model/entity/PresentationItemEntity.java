package io.ambulante.backend.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "presentationItem")
public class PresentationItemEntity extends AbstractEntity {
    private String description;
    private String location;
}
