package ru.newhope.actitem;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="acceptance_act_row")
public class ActItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Double amount;
    private Double price;
    private Date expirationDate;
    private String note;
    @Column(name = "acceptance_act_id")
    private Integer acceptanceActId;
}
