package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static int selected; // used to reflect current selected employee

    // create an instance of our employee class named employee1
    public static Employee Employee1 = new Employee("Ralph", 27, "Male", 30000,2);

    // void used to display employee 1
    public void showEmployee1(View v){


        // assign value to selected index
        selected = 1;

        // assign textView to variable then update text to reflect the selected index
        TextView select = findViewById(R.id.selectedIndex);
        select.setText(Integer.toString(selected));

        // assign edit texts to variables
        EditText name = findViewById(R.id.boxName);
        EditText age = findViewById(R.id.boxAge);
        EditText gender = findViewById(R.id.boxGender);
        EditText salary = findViewById(R.id.boxSalary);
        EditText level = findViewById(R.id.boxLvl);
        EditText retirement = findViewById(R.id.box401);
        EditText benefits = findViewById(R.id.boxBenefits);
        EditText ytr = findViewById(R.id.boxYTR);

        // update text boxes with class variables
        name.setText(Employee1.name);
        age.setText(Integer.toString(Employee1.age));
        gender.setText(Employee1.gender);
        salary.setText(Integer.toString(Employee1.salary));
        level.setText(Integer.toString(Employee1.level));
        retirement.setText("N/A");
        benefits.setText("N/A");
        ytr.setText("N/A");


    }

    // create a static instance of our union employee class named employee 2
    public static EmployeePlus Employee2 = new EmployeePlus("Jane",42, "Female", 95000, 5, "Matched", "Full", 0);

    // void used to display employee 2
    public void showEmployee2(View v){

        // assign value to selected index
        selected = 2;

        // assign textView to variable then update text to reflect the selected index
        TextView select = findViewById(R.id.selectedIndex);
        select.setText(Integer.toString(selected));


        // assign edit texts to variables
        EditText name = findViewById(R.id.boxName);
        EditText age = findViewById(R.id.boxAge);
        EditText gender = findViewById(R.id.boxGender);
        EditText salary = findViewById(R.id.boxSalary);
        EditText level = findViewById(R.id.boxLvl);
        EditText retirement = findViewById(R.id.box401);
        EditText benefits = findViewById(R.id.boxBenefits);
        EditText ytr = findViewById(R.id.boxYTR);

        // update text boxes with class variables
        name.setText(Employee2.name);
        age.setText(Integer.toString(Employee2.age));
        gender.setText(Employee2.gender);
        salary.setText(Integer.toString(Employee2.salary));
        level.setText(Integer.toString(Employee2.level));
        retirement.setText(Employee2.retirement);
        benefits.setText(Employee2.benefits);
        ytr.setText( Integer.toString( Employee2.retire() ) );
    }




    public void promoClick(View v){

        // edit text to display their new promotion, if his level isn't 5 of course. and one to display his new salary
        EditText level = findViewById(R.id.boxLvl);
        EditText pay = findViewById(R.id.boxSalary);
        String passable;

        // check which employee is selected
        if (selected == 1){
            // display Toast if employee level is at max
            if (Employee1.level == 5){
                passable = "Employee level cannot exceed 5";
                Toast.makeText(MainActivity.this,passable,Toast.LENGTH_SHORT).show();
            }

            // if selected employee is employee 1 promote him
            Employee1.promote();    // call to promote method in base class
            level.setText(Integer.toString(Employee1.level));   // display promo lvl
            pay.setText(Integer.toString(Employee1.salary));
        }


        // check which employee is selected
        if (selected == 2) {

            // if employee lvl is max, then make Toast letting the user know
            if (Employee2.level == 5) {
                passable = "Employee level cannot exceed 5";
                Toast.makeText(MainActivity.this, passable, Toast.LENGTH_SHORT).show();
            }

            // if selected employee is employee 2 promote him
            Employee2.promote();    // call to promote method in base class
            level.setText(Integer.toString(Employee2.level));   // display promo lvl
            pay.setText(Integer.toString(Employee2.salary));



        }
    }

    // onClick to give employees a raise
    public void raiseClick(View v){

        // editText for displaying salary
        EditText pay = findViewById(R.id.boxSalary);

        // if selected employee is employee 1 give him a raise
        if (selected == 1){
            Employee1.giveRaise(2500); // call to giveRaise method, arg is irrelevant
            pay.setText(Integer.toString(Employee1.salary));    // display new salary
        }

        // if selected employee is employee 2 give him a raise
        if (selected == 2){
            Employee2.giveRaise(2500); // call to giveRaise method, arg is irrelevant
            pay.setText(Integer.toString(Employee2.salary));   // display new salary
        }
    }

    // onClick to give employees a custom raise
    public void customRaise(View v){

        // text boxes for our input and displaying our employee's salary
        EditText input = findViewById(R.id.boxCustomRaise);
        EditText pay = findViewById(R.id.boxSalary);

        // Toast to display to user that this is union only feature if employee is non union
        String passable = "";
        Toast.makeText(MainActivity.this,passable,Toast.LENGTH_SHORT);


        int intInput = 0;

        // handle input to an integer if input isn't left empty
        if (!input.getText().toString().isEmpty()) {
            intInput = Integer.parseInt(input.getText().toString());
        }


        // if it's employee 1 he won't receive anything as he's non Union, however it still displays his salary again
        if (selected == 1){
            pay.setText(Integer.toString(Employee1.salary));
            passable = "Union Employee Feature Only";
            Toast.makeText(MainActivity.this,passable,Toast.LENGTH_SHORT).show();

        }

        // if it's employee 2 give him his custom raise using our modified method
        if (selected == 2){
            Employee2.giveRaise( intInput );
            pay.setText(Integer.toString(Employee2.salary));
        }

    }

}


