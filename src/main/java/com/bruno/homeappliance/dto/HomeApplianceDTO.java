package com.bruno.homeappliance.dto;

import com.bruno.homeappliance.entities.HomeAppliance;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeApplianceDTO implements Serializable {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Enter the name of the home appliance!")
    private String name;

    @Size(message = "Enter the power of the home appliance in Watts")
    private Integer power;

    private Integer monthlyUsage;
    private Integer dailyUse;

    @NotBlank(message = "Enter the appliance's average monthly consumption in kWh")
    private Double monthlyConsumptionAverage;

    public HomeApplianceDTO(HomeAppliance homeAppliance){
        name = homeAppliance.getName();
        power = homeAppliance.getPower();
        monthlyUsage = homeAppliance.getMonthlyUsage();
        dailyUse = homeAppliance.getDailyUse();
        monthlyConsumptionAverage = homeAppliance.getMonthlyConsumptionAverage();
    }

}
