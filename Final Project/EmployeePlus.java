package com.example.finalproject;

// sub class of Employee base class to represent our union employees
public class EmployeePlus extends Employee {

    // create our sub class vars
    String retirement;
    String benefits;
    int ytr;    // years to retire


    // class constructor and super
    public EmployeePlus(String name, int age, String gender, int salary, int level, String retirement, String benefits, int ytr){
        super(name, age, gender, salary, level);
        this.retirement = retirement;
        this.benefits = benefits;
        this.ytr = ytr;
    }

    // method to calculate years until retirement, (retirement age is just assumed to be 70)
    int retire(){
        ytr = 70 - age;
        return ytr;
    }

    @Override
    int giveRaise(int raise) {
        raise -= 2500;  // undo the base raise, as we want this to be a custom raise, although there's probably a better way to do most of this it should suffice
        salary+=raise;  // increment our raise based on our users input.
        return super.giveRaise(raise);
    }
}
