package manamaham.amirhossein.kafkatask.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private String description;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
}
