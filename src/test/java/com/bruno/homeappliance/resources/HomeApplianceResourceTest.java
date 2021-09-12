package com.bruno.homeappliance.resources;

import com.bruno.homeappliance.dto.HomeApplianceDTO;
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

import static org.mockito.ArgumentMatchers.nullable;
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
    void mustReturn200OkStatusWhenCallingFindByNameIgnoreCaseMethod() throws Exception {
        HomeApplianceDTO homeApplianceDTO = new HomeApplianceDTO("Vacuum", 300, 10, 1, 10.0);
        when(homeApplianceService.findByNameIgnoreCase(homeApplianceDTO.getName())).thenReturn(homeApplianceDTO);
        mockMvc.perform(MockMvcRequestBuilders.get(URN + "name?name=" + homeApplianceDTO.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Must return 200 Ok status when calling findByNameIgnoreCase method with no arguments")
    void mustReturn200OkStatusWhenCallingFindByNameIgnoreCaseMethodWithNoArguments() throws Exception {
        when(homeApplianceService.findByNameIgnoreCase("")).thenReturn(nullable(HomeApplianceDTO.class));
        mockMvc.perform(MockMvcRequestBuilders.get(URN + "name?name=")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
