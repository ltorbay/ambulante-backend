package io.ambulante.backend.model.entity;

import io.ambulante.backend.model.enums.Unit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product")
public class ProductEntity extends AbstractEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "defaultImage")
    private ImageReferenceEntity defaultImage;

    @Enumerated(EnumType.STRING)
    private Unit defaultUnit;
}
