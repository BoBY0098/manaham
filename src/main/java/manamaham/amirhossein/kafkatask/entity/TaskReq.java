package manamaham.amirhossein.kafkatask.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskReq {

    private Long id;

    private String description;

    private String status;

    private Date dueDate;
}
