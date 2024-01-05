package com.example.actuators;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id = "custom")
public class CustomActuatorEndpoint {
    @ReadOperation
    public String customEndpoint(){
        return "This is custom endpoint";
    }
}
