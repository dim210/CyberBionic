package org.example;

import org.example.beans.CargoVessel;
import org.example.configs.AppConfig;
import org.example.interfaces.Vessel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDz2_2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Dz2:");
        Vessel vessel = ctx.getBean("banderaVessel", CargoVessel.class);
        System.out.println(vessel.status());
    }}