package com.umar.apps.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FooAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() +"\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        var writer = response.getWriter();
        writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " - " + authException.getMessage());
    }


    /*
    The realm, simply put, defines the scope/space that’s protected with Basic Auth
    (along with the root URL). That way you can – for example – have different realms
    for the same URL space and configure them differently.
    The important point is that the realm isn’t optional – so when you’re using Basic Auth
    you need to define a realm – which is what that does.
     */
    @Override
    public void afterPropertiesSet() {
        setRealmName("Umar");
        super.afterPropertiesSet();
    }
}
