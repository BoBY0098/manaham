package manamaham.amirhossein.kafkatask.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    private Long id;

    private String name;

    private String department;

    private String position;

    private Double salary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
}
