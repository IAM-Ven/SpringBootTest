package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class appControllerTest {

    @Autowired
    private WebApplicationContext ctx;


    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private appController _appController;

    @Before
    public void setUp(){
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void reverseTest() throws Exception {

        final String inputStr ="hello world!";
        final String outputStr = "!dlrow olleh";

        given(_appController.reverse(inputStr)).willReturn(outputStr);

        mvc.perform(get("/reverse/" + inputStr)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(outputStr)));
    }

    @Test
    public void greetingTest() throws Exception {

        final person _person = new person();
        final greetPerson _greetPerson = new greetPerson();

        _person.name = "Atul Sahaney";
        _person.apples = 12;
        _person.pets = new String[]{"Dog", "Cat", "nnnn"};

        _greetPerson.greetPerson(_person);

        given(_appController.greetPerson(_person)).willReturn(_greetPerson);

        mvc.perform(post("/person" )
                .contentType(APPLICATION_JSON)
                .content(json(_person)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    protected String json(Object o) throws IOException {

        String str = objectMapper.writeValueAsString(o);

        return str;
    }

}