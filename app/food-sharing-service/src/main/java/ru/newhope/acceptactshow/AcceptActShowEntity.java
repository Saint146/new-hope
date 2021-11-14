package ru.newhope.acceptactshow;

import lombok.Data;
import ru.newhope.acceptactitemshow.ActItemShowEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="v_acceptance_act")
public class AcceptActShowEntity {
    @Id
    private Integer id;
    private Date acceptanceDate;
    private Integer organizationId;
    private Integer volunteerId;
    private String cityName;
    private String organizationName;
    private String volunteerName;
    private String agreementNum;
    private Date signDate;
    private String accordance;
    private String representor;
    private String representorGen;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "acceptance_act_id")
    private List<ActItemShowEntity> actItems;
}
