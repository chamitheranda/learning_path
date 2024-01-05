package com.example.profile.testing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {
    public DevConfig() {
        System.out.println("Dev tool was loaded");
    }
}
