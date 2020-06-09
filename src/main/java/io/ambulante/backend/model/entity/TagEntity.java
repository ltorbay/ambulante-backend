package io.ambulante.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tag")
public class TagEntity extends AbstractEntity {
    private String code;
    private String displayName;
}
