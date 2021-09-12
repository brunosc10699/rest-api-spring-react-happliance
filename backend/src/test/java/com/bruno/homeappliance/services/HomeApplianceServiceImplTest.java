package com.bruno.homeappliance.services;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.entities.HomeAppliance;
import com.bruno.homeappliance.repositories.HomeApplianceRepository;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HomeApplianceServiceImplTest {

    @Mock
    private HomeApplianceRepository homeApplianceRepository;

    @InjectMocks
    private HomeApplianceServiceImpl homeApplianceService;

    @Test
    @DisplayName("Must return a HomeApplianceDTO object")
    void mustReturnAHomeApplianceDTOObject(){
        HomeAppliance homeAppliance = new HomeAppliance("Vacuum", 300, 10, 1, 10.0);
        HomeApplianceDTO homeApplianceDTO;
        when(homeApplianceRepository.findByNameIgnoreCase("vacuum")).thenReturn(Optional.of(homeAppliance));
        homeApplianceDTO = homeApplianceService.findByNameIgnoreCase("vacuum");
        assertAll(
                () -> assertThat(homeApplianceDTO.getName(), is(equalTo("Vacuum"))),
                () -> assertThat(homeApplianceDTO.getPower(), is(equalTo(300))),
                () -> assertThat(homeApplianceDTO.getMonthlyUse(), is(equalTo(10))),
                () -> assertThat(homeApplianceDTO.getDailyUse(), is(equalTo(1))),
                () -> assertThat(homeApplianceDTO.getAverageMonthlyConsumption(), is(equalTo(10.0)))
        );
    }

    @Test
    @DisplayName("Must return an empty object")
    void mustReturnAnEmptyObject(){
        HomeApplianceDTO homeApplianceDTO;
        when(homeApplianceRepository.findByNameIgnoreCase("vacuum")).thenReturn(Optional.empty());
        homeApplianceDTO = homeApplianceService.findByNameIgnoreCase("vacuum");
        assertAll(
                () -> assertThat(homeApplianceDTO.getName(), is(nullValue())),
                () -> assertThat(homeApplianceDTO.getPower(), is(nullValue())),
                () -> assertThat(homeApplianceDTO.getMonthlyUse(), is(nullValue())),
                () -> assertThat(homeApplianceDTO.getDailyUse(), is(nullValue())),
                () -> assertThat(homeApplianceDTO.getAverageMonthlyConsumption(), is(nullValue()))
        );
    }
}
