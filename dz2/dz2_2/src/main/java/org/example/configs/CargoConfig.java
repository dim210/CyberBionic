package org.example.configs;

import org.example.beans.CoalCargo;
import org.example.interfaces.Cargo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargoConfig {
    @Bean
    public CoalCargo coalCargo() {
        return new CoalCargo(8000);
    }
}
