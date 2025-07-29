package org.example;

import org.example.beans.CargoVessel;
import org.example.interfaces.Vessel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDz2_3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app3Context.xml");
        System.out.println("ex1:");
        Vessel vessel = context.getBean("CargoVessel", CargoVessel.class);
        System.out.println(vessel.status());
    }
}