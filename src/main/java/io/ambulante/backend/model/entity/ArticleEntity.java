package io.ambulante.backend.model.entity;

import io.ambulante.backend.model.enums.Unit;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractEntity {
    private Integer quantity;
    private Unit unit;
    private BigDecimal pricePerUnit;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product")
    private ProductEntity product;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "image")
    private ImageReferenceEntity image;
}
