package com.bruno.homeappliance.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_home_appliance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeAppliance implements Serializable {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    @Column(nullable = false)
    private Integer power;

    private Integer monthlyUse;
    private Integer dailyUse;

    @Column(nullable = false)
    private Double averageMonthlyConsumption;
}
