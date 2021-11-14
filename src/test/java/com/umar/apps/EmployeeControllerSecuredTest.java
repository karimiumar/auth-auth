package com.umar.apps;

import com.umar.apps.auth.security.WebSecurityConfig;
import com.umar.apps.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = EmployeeController.class)
@ActiveProfiles("prod")
public class EmployeeControllerSecuredTest {
    
    @Autowired MockMvc mockMvc;
    
    @MockBean WebSecurityConfig webSecurityConfig;
    
    @Test
    void whenSecurityEnabled_shouldBeForbidden() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isForbidden());
    }
}
