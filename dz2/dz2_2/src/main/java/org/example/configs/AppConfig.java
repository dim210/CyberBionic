package org.example.configs;

import org.example.beans.CargoVessel;
import org.example.beans.CoalCargo;
import org.example.beans.DieselFuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CargoConfig.class)
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Autowired
    @Qualifier("coalCargo")
    private CoalCargo coalCargo;

    @Bean
    public DieselFuel dieselFuel() {
        return new DieselFuel(1500);
    }
    @Bean
    public CargoVessel banderaVessel() {
        CargoVessel vessel = new CargoVessel("StepanBandera","MiddleCargo");
        //vessel.setCargo(coalCargo);
        vessel.setFuel(dieselFuel());
        //vessel.init();
        return vessel;
    }

}
