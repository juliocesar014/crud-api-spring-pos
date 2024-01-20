package com.example.api2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pos")
@OpenAPIDefinition(info=@Info(title="API v1", description = "with spring boot - Pós 2024."))
@Tag(name="1. Pós Controller")
public class PosController {
    @GetMapping("/hello")
    public String hello() {
        return "Júlio Api";
    }


}
