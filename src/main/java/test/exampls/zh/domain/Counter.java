package test.exampls.zh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="counters")
@NoArgsConstructor
@AllArgsConstructor
public class Counter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="amount")
    private Float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "village_id")
    private Village village;
}
