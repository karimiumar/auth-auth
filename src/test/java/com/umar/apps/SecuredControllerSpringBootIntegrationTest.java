package com.umar.apps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredControllerSpringBootIntegrationTest {
    
    @Autowired WebApplicationContext ctx;
    
    private MockMvc mvc;
    
    @BeforeEach
    void before() {
        mvc = MockMvcBuilders
                .webAppContextSetup(ctx)
                .apply(springSecurity())
                .build();
    }
    
    @Test
    void giveRequestOnPrivateService_shouldFailWith401() throws Exception {
        mvc.perform(get("/private/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
    
    @WithMockUser("user1")
    @Test
    void givenRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/private/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
            
}

