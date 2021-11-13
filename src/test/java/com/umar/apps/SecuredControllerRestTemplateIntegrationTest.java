package com.umar.apps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredControllerRestTemplateIntegrationTest {
    
    @Autowired TestRestTemplate template;
    
    @Test
    public void givenRequestOnPrivateService_shouldFailWith401() {
        var result = template.getForEntity("/private/hello", String.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
    
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() {
        var result = template.withBasicAuth("user1", "user1Pass")
            .getForEntity("/private/hello", String.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
