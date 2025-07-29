package com.dz3_1.mvc.controllers;

import com.dz3_1.mvc.FileStorage;
import com.dz3_1.mvc.models.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/task23")
public class FirstController {
    /*@Autowired
    private ApplicationContext applicationContext;*/

    private final ApplicationContext applicationContext;

    @Autowired
    public FirstController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/")
    public String takeRoot() {
        return "redirect:form";
    }

    @GetMapping("/form")
    public String takeForm() {
        return "form";
    }

    @PostMapping("/form")
    public ModelAndView takeFormAction(@ModelAttribute("form-record") Record record, ModelAndView modelAndView) {
//        System.out.println(record);
        modelAndView.setViewName("forward:form-action");
        modelAndView.addObject("out_rec", record);
//        System.out.println("context");
        FileStorage file = applicationContext.getBean("FileStorage", FileStorage.class);
        if (file.IsWriteOk(record.toString())) {
            modelAndView.addObject("mess", "Successfully saved,<br> total saved lines:" + file.getSavedRowCount());
        } else {
            modelAndView.addObject("mess", "Something wrong! Data not saved,<br> total saved lines:" + file.getSavedRowCount());
        }
        return modelAndView;
    }

    @PostMapping("/form-action")
    public String takeFormActionRez() {
        return "form-action";
    }

    @GetMapping("/show-all")
    public ModelAndView showSavedData(ModelAndView modelAndView) {
        modelAndView.setViewName("show-all-records");
        FileStorage file = applicationContext.getBean("FileStorage", FileStorage.class);
        modelAndView.addObject("all_rec", file.getAllRows());
        modelAndView.addObject("fileName", file.getFileName());
        return modelAndView;
    }

    @GetMapping(value = "/greeting/{userName}")
    public ModelAndView showGreeting(@PathVariable String userName, ModelAndView modelAndView) {
        System.out.println(userName);
//        modelAndView.setViewName("forward:greeting");
        modelAndView.setViewName("greeting");
        modelAndView.addObject("uName", userName);
        return modelAndView;
    }

}
