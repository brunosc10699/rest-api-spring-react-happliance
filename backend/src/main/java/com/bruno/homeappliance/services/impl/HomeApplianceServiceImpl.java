package com.bruno.homeappliance.services.impl;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.entities.HomeAppliance;
import com.bruno.homeappliance.repositories.HomeApplianceRepository;
import com.bruno.homeappliance.services.HomeApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeApplianceServiceImpl implements HomeApplianceService {

    private final HomeApplianceRepository homeApplianceRepository;

    @Override
    public HomeApplianceDTO findByNameIgnoreCase(String name) {
        HomeAppliance homeAppliance = homeApplianceRepository.findByNameIgnoreCase(name)
                .orElse(new HomeAppliance());
        return new HomeApplianceDTO(homeAppliance);
    }

    @Override
    public List<String> findAllProductNames() {
        return homeApplianceRepository.findAllProductNames();
    }
}
