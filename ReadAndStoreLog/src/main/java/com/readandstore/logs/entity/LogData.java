package com.readandstore.logs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Table(name="log_data")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="log_desc")
    private String logDesc;
    @Column(name = "created_date")
    private Date createdDate;

}
