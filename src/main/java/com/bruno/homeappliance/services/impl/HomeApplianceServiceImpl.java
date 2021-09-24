package com.bruno.homeappliance.services.impl;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.entities.HomeAppliance;
import com.bruno.homeappliance.repositories.HomeApplianceRepository;
import com.bruno.homeappliance.services.HomeApplianceService;
import com.bruno.homeappliance.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeApplianceServiceImpl implements HomeApplianceService {

    private final HomeApplianceRepository homeApplianceRepository;

    @Transactional(readOnly = true)
    @Override
    public HomeApplianceDTO findByNameIgnoreCase(String name) {
        HomeAppliance homeAppliance = homeApplianceRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ResourceNotFoundException(name));
        return new HomeApplianceDTO(homeAppliance);
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findAllProductNames() {
        return homeApplianceRepository.findAllProductNames();
    }
}
