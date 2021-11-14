package ru.newhope.acceptactitemshow;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="v_acceptance_act_row")
public class ActItemShowEntity {
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
    private String productName;
    private String measurementName;
}
