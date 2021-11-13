package com.umar.apps;

import com.umar.apps.controller.SecuredService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
public class SecuredMethodSpringBootIntegrationTest {
    
    @Autowired SecuredService service;
    
    @Test
    void givenUnauthenticated_whenCallService_ThenException() {
        assertThatThrownBy(() -> service.sayHelloSecured()).hasMessage("An Authentication object was not found in the SecurityContext");
    }
    
    @WithMockUser("user1")
    @Test
    void givenAuthenticated_whenCallService_ThenSuccess() {
        assertThat(service.sayHelloSecured()).isEqualTo("Hello User!!@");
    }
}
