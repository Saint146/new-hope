package ru.newhope.transferact;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="accept_transfer")
public class TransferActEntity {
    @Id
    private Integer id;
    private String name;
}
