package com.dundyne.androidworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    EditText weight, height, age;
    Boolean gender = true; // true male, false female
    TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }
    public void calcTDEE(View v){
        /*Mifflin-St Jeor Equation
        Mifflin = (10.m + 6.25h - 5.0a) + s

        m is mass in kg, h is height in cm, a is age in years, s is +5 for males and -151 for females
        */
        weight = (EditText)findViewById(R.id.WeightTxt);
        height = (EditText)findViewById(R.id.HeightTxt);
        age = (EditText)findViewById(R.id.AgeTxt);
        results = (TextView)findViewById(R.id.ResultsTDEE);
        int parsedWeight = Integer.parseInt(weight.getText().toString());
        int parsedHeight = Integer.parseInt(height.getText().toString());
        int parsedAge = Integer.parseInt(age.getText().toString());
        int s;
        if (gender) {
            s = 5;
        }
        else {
            s = -161;
        }
        float resultsFloat = (10 * parsedWeight) + (6.25f * parsedHeight) - (5 * parsedAge) + s;
        results.setText(String.valueOf(resultsFloat) + " Calories Daily");
    }

    public class SpinnerActivity extends SecondActivity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            if (parent.getItemAtPosition(pos) == "Male"){
                gender = true;
            }
            else gender = false;
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
}


}
