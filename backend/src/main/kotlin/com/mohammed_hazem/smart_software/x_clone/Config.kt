package com.mohammed_hazem.smart_software.x_clone

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class Config {
    @Bean
    fun sec(httpSecurity: HttpSecurity): SecurityFilterChain = httpSecurity.csrf {
        it.disable()
    }
        .sessionManagement {
            it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }.authorizeHttpRequests {
            it.requestMatchers("/email/**")
                .permitAll()
            
        }
        .build()
}