package com.example.demo;


/**
 * Created by atulsahaney on 9/12/17.
 */

public class greetPerson {
    public String greeting;
    public int apples;
    public String greetPets;

    public greetPerson greetPerson(person _person){
        this.greeting = greeting(_person.name);
        this.apples = howManyApples(_person.apples);
        this.greetPets = greetPets(_person.pets);

        return this;
    }

    private String greeting(String name){
        return name = "Hi " + name + ", how are you?";
    }

    private int howManyApples(int apples){
        return apples;
    }

    private String greetPets(String[] pets){

        StringBuilder str = new StringBuilder();
        for(String pet: pets){
            str.append(pet == "Hi " + pet + ", YOU\'RE JUST SO FLUFFY! :O ");
        }
        return str.toString();
    }
}
