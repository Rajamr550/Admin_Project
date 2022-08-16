package com.zensar.config;

import org.springframework.boot.test.context.SpringBootTest;

import com.zensar.AdminRestApiApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = AdminRestApiApplication.class)
public class CucumberConfiguration {

}
