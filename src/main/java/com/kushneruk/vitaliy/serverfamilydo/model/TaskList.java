package com.kushneruk.vitaliy.serverfamilydo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskList {
    @Id
    private Integer uid;
    private String name;
    private Date dateCreate;
}
