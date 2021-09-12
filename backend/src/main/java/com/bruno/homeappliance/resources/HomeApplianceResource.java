package com.bruno.homeappliance.resources;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/appliances")
@RequiredArgsConstructor
public class HomeApplianceResource {

    private final HomeApplianceServiceImpl homeApplianceService;

    @GetMapping(value = "/name")
    public ResponseEntity<HomeApplianceDTO> findByNameIgnoreCase(@RequestParam String name){
        return ResponseEntity.ok(homeApplianceService.findByNameIgnoreCase(name));
    }
}
