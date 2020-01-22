package test.exampls.zenhomes.domain;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name="events")
public class Event implements Serializable {
    private transient static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "created_on")
    @CreationTimestamp
    private Timestamp createdOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EventType type;

    @Column(name = "payload")
    private String payload;

//    @Column(name = "status", nullable = false)
//    private EventStatus status;
//
//    @Version
//    private int version;
}
