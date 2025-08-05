package com.dz4_jpa.mvc.controllers;

import com.dz4_jpa.persistence.dao.services.interfaces.CarsService;
import com.dz4_jpa.persistence.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/task4")
public class CarsController {
    /*    private final ApplicationContext applicationContext;

        @Autowired
        public CarsController(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }*/
    private CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("")
    public String takeEmtyRoot() {
        return "redirect:task4/";
    }

    @GetMapping("/")
    public String takeRoot() {
        return "root";
    }

    @GetMapping("/show-all")
    public ModelAndView showSavedData(ModelAndView modelAndView) {
        modelAndView.setViewName("show-list");
        modelAndView.addObject("list_rec", carsService.findAll());
        modelAndView.addObject("headerLine", "All Cars:");
        return modelAndView;
    }

    @GetMapping("/form")
    public String takeForm() {
        return "form";
    }

    @PostMapping("/addform")
    public ModelAndView takeFormAction(HttpServletRequest request, ModelAndView modelAndView) {
        Car car = new Car();
        car.setBrandName(request.getParameter("fBrandName"));
        car.setModelName(request.getParameter("fModelName"));
        car.setPrice(Double.parseDouble(request.getParameter("fPrice")));
        Car addedCar = carsService.addCar(car);
        System.out.println("New car with id " + addedCar.getId() + " was added.");
//        return "redirect:/employee/all";
        modelAndView.addObject("out_rec", addedCar);
        modelAndView.addObject("mess", "new car was saved:");
        modelAndView.setViewName("forward:form-action");
        return modelAndView;
    }

    @PostMapping("/form-action")
    public String takeFormActionRez() {
        return "form-action";
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteCar(@PathVariable long id, ModelAndView modelAndView) {
        carsService.removeCarById(id);
        String mess = "Car with id " +Long.toString(id) + " was deleted.";
        System.out.println(mess);
//        modelAndView.addObject("mess", mess);
        modelAndView.setViewName("redirect:../show-all");
/*        modelAndView.addObject("list_rec", carsService.findAll());
        modelAndView.addObject("headerLine",  mess + "\n All Cars:");*/
        return modelAndView;
    }

    @PostMapping("/findByBrandName")
    public ModelAndView takeByBrandName(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("show-list");
        modelAndView.addObject("list_rec", carsService.findCarsByBrandName(request.getParameter("fBrandName")));
        modelAndView.addObject("headerLine", "All Cars by brand name "+request.getParameter("fBrandName")+":");
        return modelAndView;
    }

    @PostMapping("/findByBrandNameAndModelName")
    public ModelAndView takeByBrandNameAndModelName(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("show-list");
        modelAndView.addObject("list_rec", carsService.findCarsByBrandNameAndModelName(request.getParameter("fBrandName"),request.getParameter("fModelName")));
        modelAndView.addObject("headerLine", "All Cars by brand name "+request.getParameter("fBrandName")+" and model name "+request.getParameter("fModelName")+":");
        return modelAndView;
    }

    @PostMapping("/findByPriceRange")
    public ModelAndView takeByPriceRange(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("show-list");
        modelAndView.addObject("list_rec", carsService.findCarsByPriceRange(Double.parseDouble(request.getParameter("fFromPrice")),Double.parseDouble(request.getParameter("fToPrice"))));
        modelAndView.addObject("headerLine", "All Cars by price range from:"+request.getParameter("fFromPrice")+" to:"+request.getParameter("fToPrice")+":");
        return modelAndView;
    }

    @PostMapping("/delById")
    public ModelAndView delById(HttpServletRequest request, ModelAndView modelAndView) {
        carsService.delByIdQuery(Long.parseLong(request.getParameter("fDelById")));
        String mess = "Car with id " +request.getParameter("fDelById") + " was deleted by query.";
        System.out.println(mess);
        modelAndView.setViewName("show-list");
        modelAndView.addObject("list_rec", carsService.findAll());
        modelAndView.addObject("headerLine", mess+". All Cars:");
        return modelAndView;
    }

}
