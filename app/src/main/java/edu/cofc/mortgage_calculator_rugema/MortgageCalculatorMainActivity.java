package edu.cofc.mortgage_calculator_rugema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MortgageCalculatorMainActivity extends AppCompatActivity  implements View.OnClickListener {
    //create instance variable for widgets
    private EditText homeValue;
    private EditText interestRate;
    private EditText loanAmount;
    private EditText loanTerm;
    private EditText propertyTax;
    private EditText pmi;
    private EditText homeInsurance;
    private EditText monthlyhomeHOA;
    private Button calculateBtn;
    private Button summaryBtn;
    private String month, year;
    private Intent i;
    private TextView textMonth, textYear;
    private static final String SAVED_NUM_LOAN = "savedNumLoan";
    private static final String SAVED_NUM_VALUE = "savedNumLoanValue";
    private static final String SAVED_NUM_RATE = "savedRate";
    private static final String SAVED_NUM_TERM = "savedNumLoanTerm";
    private static final String SAVED_NUM_DATE = "savedNumDate";
    private static final String SAVED_NUM_P_TAX = "savedNumPTax";
    private static final String SAVED_NUM_PMI = "savedNumPMI";
    private static final String SAVED_NUM_H_INS = "savedNumHomeIns";
    private static final String SAVED_NUM_HOA = "savedNumHOA";


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


        loanAmount = (EditText) findViewById(R.id.loanAmountText);
        loanTerm = (EditText) findViewById(R.id.loanTermText);
        homeValue =(EditText) findViewById(R.id.homeValueText);
        homeInsurance = (EditText) findViewById(R.id.homeInsText);
        monthlyhomeHOA = (EditText) findViewById(R.id.monthlyHOAText);
        propertyTax = (EditText) findViewById(R.id.propertyTaxText);
        interestRate = (EditText) findViewById(R.id.interestRateText);
        pmi = (EditText) findViewById(R.id.pmiText);

        calculateBtn = (Button) findViewById(R.id.calculate);
        summaryBtn = (Button) findViewById(R.id.summaryBtn);

        //get value from spinners
        textMonth = (TextView) monthSpinner.getSelectedView();
        textYear = (TextView) yearSpinner.getSelectedView();
        month = textMonth.getText().toString();
        year = textYear.getText().toString();


        //sets listeners
        calculateBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(SAVED_NUM_VALUE, homeValue.getText().toString());
        outState.putString(SAVED_NUM_LOAN, loanAmount.getText().toString());
        outState.putString(SAVED_NUM_RATE, interestRate.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        homeValue.setText(savedInstanceState.getString(SAVED_NUM_VALUE));
        loanAmount.setText(savedInstanceState.getString(SAVED_NUM_LOAN));
        interestRate.setText(savedInstanceState.getString(SAVED_NUM_RATE));
    }

    public void calculateAndDisplay(){

    }

    private double computeLoanPayment(double amount, double rate, int period){
        return (amount * rate) / (1 - Math.pow(1/(1 + rate), period));
    }

    private double getTotalPayment(){
        double totalPayment = 0.0;
        //totalPayment = computeLoanPayment() * numberOfPayments;
        return totalPayment;
    }
}
