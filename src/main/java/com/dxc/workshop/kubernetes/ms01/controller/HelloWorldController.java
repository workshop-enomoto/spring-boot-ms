package com.dxc.workshop.kubernetes.ms01.controller;

import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/hello-springboot")
@Slf4j
public class HelloWorldController {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final String message = "Hello World Spring Boot";
    
    @RequestMapping(method = RequestMethod.GET)
    public String HelloWorld() {
        int localCounter = counter.incrementAndGet();

        String hostName;
        try { 
            hostName = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e) {
            hostName = e.getMessage();
        }

        log.info(message + ": "  + hostName + " -> " + localCounter);
        return message + ": "  + hostName + " -> " + localCounter; 
    }
}
