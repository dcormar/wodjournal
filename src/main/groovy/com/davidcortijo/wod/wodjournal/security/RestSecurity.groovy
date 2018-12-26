package com.davidcortijo.wod.wodjournal.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
class RestSecurity extends WebSecurityConfigurerAdapter {

    @Value('${security.enable-csrf}')
    boolean csrfEnabled

    @Override
    void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().
                httpBasic().and().
                csrf().disable()
    }
}
