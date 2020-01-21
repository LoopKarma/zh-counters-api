package test.exampls.zenhomes.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="counters")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="amount")
    private Float amount;

    @Column(name="villageId")
    private Integer villageId;
}
