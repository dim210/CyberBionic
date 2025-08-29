package com.dz5.mvc.controllers;

import com.dz5.persistence.models.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.validation.ConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appContextJpaTest.xml"})
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/appContextMVCTest.xml"})
@WebAppConfiguration
//@FixMethodOrder
public class CarsControllerTest {
    private MockMvc mockMvc;

    @Autowired
    CarsController carsController;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /*@After
    public void tearDown() throws Exception {
    }*/

    @Test
    public void checkShowAll() throws Exception {
        mockMvc.perform((get("/task4/show-all")))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testViewShowAll() throws Exception {
        mockMvc.perform(get("/task4/show-all"))
                .andDo(print())
                .andExpect(view().name("show-list"));

    }

    @Test
    public void addNewCar() throws Exception {
        mockMvc.perform(post("/task4/addform")
                        .param("fBrandName", "jeep")
                        .param("fModelName", "wrangler")
                        .param("fPrice", "68000.32"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }

   /* @Test
    public void findByBrandName1() throws Exception {
        mockMvc.perform(post("/task4/findByBrandName")
                .flashAttr("form-record",new Car("jeep","wr","77934")) // for @ModelAttribute
        ;*/

    @Test
    public void deleteExistCarSuccess() throws Exception {// у таблиці до тесту присутній запис з id=3
        Object addedCar = mockMvc.perform(post("/task4/addform")
                        .param("fBrandName", "jeep")
                        .param("fModelName", "wrangler")
                        .param("fPrice", "68000.32"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn().getModelAndView().getModel().get("out_rec");
        if (addedCar instanceof Car) {
            Car carToDel = (Car) addedCar;
            System.out.println("added car: " + carToDel + " with id: " + carToDel.getId());
            mockMvc.perform(get("/task4/delete/{id}", carToDel.getId()))
                    .andDo(print())
                    .andExpect(status().is3xxRedirection())
            ;
        }
    }

    @Test
    public void findByBrandName() throws Exception {
        mockMvc.perform(post("/task4/findByBrandName")
                        .param("fBrandName", "jeep"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;

/*        Assert.assertTrue(
                mockMvc.perform(post("/task4/findByBrandName")
                        .param("fBrandName","jeep"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString().contains("jeep") // for rest resp

        );*/
    }


    //parameters validations tests -----------------

    @Test(expected = IllegalArgumentException.class)
    public void deleteCarValidation1() throws Exception {
        mockMvc.perform(get("/task4/delete/{id}", null))
                .andDo(print());
    }

    @Test(expected = ConstraintViolationException.class)
    public void deleteCarValidation2() throws Exception {
        carsController.deleteCar(0, new ModelAndView()); // id = 0
    }

    @Test(expected = ConstraintViolationException.class)
    public void deleteCarValidation3() throws Exception {
        carsController.deleteCar(101, new ModelAndView()); // id more than 100
    }

    @Test(expected = EmptyResultDataAccessException.class)
//    @Test//(expected = NestedServletException.class)
    public void deleteCarNoData() throws Exception {// у таблиці до тесту відсутній запис з id=4
        carsController.deleteCar(40, new ModelAndView()); // id between 1 and 100
    }
}