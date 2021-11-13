package com.umar.apps;

import com.umar.apps.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerNoSecurityTest {
    
    
    @Autowired MockMvc mockMvc;
    
    @Test
    void whenSecurityDisabled_ThenSuccess() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }
}
