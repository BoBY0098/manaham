package manamaham.amirhossein.kafkatask.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EmployeeReq {

    private Long id;

    private String name;

    private String department;

    private String position;

    private Double salary;

    private Date dueDate;

    List<TaskReq> tasks = new ArrayList<>();
}
