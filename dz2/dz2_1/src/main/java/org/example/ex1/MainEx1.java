package org.example.ex1;

import org.example.ex1.beans.CargoVessel;
import org.example.ex1.beans.CoalCargo;
import org.example.ex1.interfaces.Cargo;
import org.example.ex1.interfaces.Vessel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEx1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app1Context.xml");
        System.out.println("ex1:");
        Vessel vessel = context.getBean("CargoVessel", CargoVessel.class);
        System.out.println(vessel.status());
    }
}