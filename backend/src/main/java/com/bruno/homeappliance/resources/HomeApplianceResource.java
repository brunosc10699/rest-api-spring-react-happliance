package com.bruno.homeappliance.resources;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/appliances")
@RequiredArgsConstructor
public class HomeApplianceResource {

    private final HomeApplianceServiceImpl homeApplianceService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<HomeApplianceDTO> findByNameIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(homeApplianceService.findByNameIgnoreCase(name));
    }

    @GetMapping
    public ResponseEntity<List<String>> findAllProductNames(){
        return ResponseEntity.ok(homeApplianceService.findAllProductNames());
    }
}
