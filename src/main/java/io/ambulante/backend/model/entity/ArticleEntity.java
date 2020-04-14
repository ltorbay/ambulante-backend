package io.ambulante.backend.model.entity;

import io.ambulante.backend.model.enums.Unit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractEntity {
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    private BigDecimal pricePerUnit;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product")
    private ProductEntity product;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "image")
    private ImageReferenceEntity image;
}
