package ru.newhope.acceptact;

import lombok.Data;
import ru.newhope.actitem.ActItemEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name="acceptance_act")
public class AcceptActEntity {
    @Id
    private Integer id;
    private Date acceptanceDate;
    private Integer organizationId;
    private Integer volunteerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "acceptance_act_id")
    private List<ActItemEntity> actItems;
}
