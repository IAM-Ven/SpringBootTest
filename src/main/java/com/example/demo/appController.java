package com.example.demo;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by atulsahaney on 9/11/17.
 */

public class appController {


    reverse _reverse;


    greetPerson _greet;

    @RequestMapping(value = "/reverse/{str}", method = GET)
    public String reverse(@RequestBody String str){

        return _reverse.reversed(str);
    }

    @RequestMapping(value = "/person", method = POST)
    public greetPerson greetPerson(@PathVariable person person){

        return _greet.greetPerson(person);

    }
}
