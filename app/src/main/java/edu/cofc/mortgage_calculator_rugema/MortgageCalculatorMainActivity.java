package edu.cofc.mortgage_calculator_rugema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MortgageCalculatorMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator_main);

        Spinner monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        Spinner yearSpinner = (Spinner) findViewById(R.id.yearSpinner);

        //Create an ArrayAdapter using string array
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.arr_months, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.arr_years, android.R.layout.simple_spinner_dropdown_item);

        //specify the layout to use
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set the adapter
        monthSpinner.setAdapter(monthAdapter);
        yearSpinner.setAdapter(yearAdapter);
    }

}
