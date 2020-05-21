package com.example.finalproject;

public class Employee {
    // define class variables
    String name;
    int age;
    String gender;
    int salary;
    int level;

    //define class constructor
    public Employee(String name, int age, String gender, int salary, int level){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.level = level;
    }

    // define class methods

        // method for giving
    int giveRaise(int raise){   // args not needed for the base class but for overriding the method in the sub class it was
        raise = 2500;           // assign value to the argument internally for a fixed rate raise
        salary += raise;        // increment employee's salary
        return salary;
    }

        // method to increment employee's level up to lvl 5
    int promote(){
        if (level < 5){ // ensure level doesn't exceed 5
            level = level + 1;
            giveRaise(5000);    // only union members would get the doubled raise, as it requires the modified method, unfortunately our only union member is level 5 already
        }
        return level;
    }
}
