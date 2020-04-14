package io.ambulante.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "image_reference")
public class ImageReferenceEntity  extends AbstractEntity {
    private String reference;
    private String displayLabel;
}
