package com.bruno.homeappliance.resources;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/appliances")
@RequiredArgsConstructor
public class HomeApplianceResource {

    private final HomeApplianceServiceImpl homeApplianceService;

    @GetMapping(value = "/name")
    public ResponseEntity<HomeApplianceDTO> findByNameIgnoreCase(@RequestParam(value = "name") String name){
        return ResponseEntity.ok(homeApplianceService.findByNameIgnoreCase(name));
    }

    @GetMapping(value = "/names/get")
    public ResponseEntity<List<String>> findAllProductNames(){
        return ResponseEntity.ok(homeApplianceService.findAllProductNames());
    }
}
