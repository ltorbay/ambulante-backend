package io.ambulante.backend.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "presentationItem")
public class ProducerEntity extends AbstractEntity {
    private String name;

    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleEntity> articles;

    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresentationItemEntity> presentationList;

}
