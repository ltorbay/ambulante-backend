package io.ambulante.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.locationtech.jts.geom.Point;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "producer")
public class ProducerEntity extends AbstractEntity {
    private UUID userId;
    private String name;
    private Point coordinates;

    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleEntity> articles;

    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresentationItemEntity> presentationList;
}
