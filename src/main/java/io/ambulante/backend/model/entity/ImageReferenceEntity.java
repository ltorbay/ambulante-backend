package io.ambulante.backend.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "imageReference")
public class ImageReferenceEntity  extends AbstractEntity {
    private String reference;
    private String displayLabel;
}
