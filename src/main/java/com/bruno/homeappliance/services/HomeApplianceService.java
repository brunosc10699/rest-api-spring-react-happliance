package com.bruno.homeappliance.services;

import com.bruno.homeappliance.dto.HomeApplianceDTO;

public interface HomeApplianceService {

    HomeApplianceDTO findByNameIgnoreCase(String name);
}
