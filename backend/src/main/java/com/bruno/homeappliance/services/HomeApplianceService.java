package com.bruno.homeappliance.services;

import com.bruno.homeappliance.dto.HomeApplianceDTO;

import java.util.List;

public interface HomeApplianceService {

    HomeApplianceDTO findByNameIgnoreCase(String name);

    List<String> findAllProductNames();
}
