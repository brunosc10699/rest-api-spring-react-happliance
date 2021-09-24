package com.bruno.homeappliance.services;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.entities.HomeAppliance;
import com.bruno.homeappliance.repositories.HomeApplianceRepository;
import com.bruno.homeappliance.services.exceptions.ResourceNotFoundException;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HomeApplianceServiceImplTest {

    @Mock
    private HomeApplianceRepository homeApplianceRepository;

    @InjectMocks
    private HomeApplianceServiceImpl homeApplianceService;

    @Test
    @DisplayName("Must return a HomeApplianceDTO object when calling findByNameIgnoreCase repository method")
    void whenCallingFindByNameIgnoreCaseMethodThenReturnAHomeApplianceDTOObject(){
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
    @DisplayName("Must throw an exception when calling findByNameIgnoreCase repository method")
    void whenCallingFindByNameIgnoreCaseMethodThenThrowResourceNotFoundException(){
        when(homeApplianceRepository.findByNameIgnoreCase("vacuum")).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> homeApplianceService.findByNameIgnoreCase("vacuum"));
    }

    @Test
    @DisplayName("Must return a list of home appliance names when calling findAllProductNames repository method")
    void whenCallingFindAllProductNamesMethodThenReturnAListOfHomeApplianceNames(){
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Vacuum", "Sound System", "Refrigerator"));
        when(homeApplianceRepository.findAllProductNames()).thenReturn(names);
        List<String> applianceNames = homeApplianceService.findAllProductNames();
        assertAll(
                () -> assertThat(applianceNames.size(), is(equalTo(names.size()))),
                () -> assertThat(applianceNames.isEmpty(), is(equalTo(false))),
                () -> assertThat(applianceNames.get(0), is(equalTo("Vacuum")))
        );
    }

    @Test
    @DisplayName("Must return an empty list of home appliance names when calling findAllProductNames repository method")
    void whenCallingFindAllProductNamesMethodThenReturnAnEmptyListOfHomeApplianceNames(){
        List<String> names = new ArrayList<>();
        when(homeApplianceRepository.findAllProductNames()).thenReturn(names);
        List<String> applianceNames = homeApplianceService.findAllProductNames();
        assertThat(applianceNames.isEmpty(), is(equalTo(true)));
    }
}
