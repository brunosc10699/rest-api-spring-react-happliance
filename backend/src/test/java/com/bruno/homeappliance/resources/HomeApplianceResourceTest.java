package com.bruno.homeappliance.resources;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
import com.bruno.homeappliance.services.exceptions.ResourceNotFoundException;
import com.bruno.homeappliance.services.impl.HomeApplianceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class HomeApplianceResourceTest {

    private static final String URN = "/api/v1/appliances/";

    @Mock
    private HomeApplianceServiceImpl homeApplianceService;

    @InjectMocks
    private HomeApplianceResource homeApplianceResource;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(homeApplianceResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    @DisplayName("Must return 200 Ok status when calling findByNameIgnoreCase method with arguments")
    void whenCallingFindByNameIgnoreCaseMethodMustReturn200OkStatus() throws Exception {
        HomeApplianceDTO homeApplianceDTO = new HomeApplianceDTO("Vacuum", 300, 10, 1, 10.0);
        String name = "Vacuum";
        when(homeApplianceService.findByNameIgnoreCase(name)).thenReturn(homeApplianceDTO);
        mockMvc.perform(MockMvcRequestBuilders.get(URN + name + "/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Must return 404 NotFound status when calling findByNameIgnoreCase method with invalid arguments")
    void whenCallingFindByNameIgnoreCaseMethodWithInvalidArgumentsMustReturn404NotFoundStatus() throws Exception {
        String name = "a";
        doThrow(ResourceNotFoundException.class).when(homeApplianceService).findByNameIgnoreCase(name);
        mockMvc.perform(MockMvcRequestBuilders.get(URN + name + "/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When GET is called return 200 OK Status")
    void whenGETIsCalledThenReturn200OKStatus() throws Exception {
        String name = "Vacuum";
        when(homeApplianceService.findAllProductNames()).thenReturn(Collections.singletonList(name));
        mockMvc.perform(MockMvcRequestBuilders.get(URN + "names/get")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("When GET is called return 200 OK Status and an empty list of home appliance names")
    void whenGETIsCalledThenReturnAnEmptyListAnd200OKStatus() throws Exception {
        when(homeApplianceService.findAllProductNames()).thenReturn(Collections.singletonList(null));
        mockMvc.perform(MockMvcRequestBuilders.get(URN + "names/get")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }
}