package com.baeldung.spring.cloud.springcloudcontractconsumer.controller;


import com.baeldung.spring.cloud.springcloudcontractconsumer.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class BasicMathController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Config config;

    @GetMapping("/calculate")
    public String checkOddAndEven(@RequestParam("number") Integer number) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
          config.getEndpoint()+":8090/validate/prime-number?number=" + number,
          HttpMethod.GET,
          new HttpEntity<>(httpHeaders),
          String.class);

        return responseEntity.getBody();
    }
}
