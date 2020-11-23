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

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    GraphView linegraph;
    TinyDB tinydb;
    String exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        tinydb = new TinyDB(getApplicationContext());
        linegraph = (GraphView) findViewById(R.id.line_graph);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        createGraph();

    }

    public class SpinnerActivity extends SecondActivity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            if (parent.getItemAtPosition(pos) != null){
                exercise = parent.getItemAtPosition(pos).toString();
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }


    public void createGraph(){

        int count = 0;

        //Implementer senere ArrayList<Integer> progress = tinydb.getListInt(exercise);
        ArrayList<Integer> progress = tinydb.getListInt("pushup");
        DataPoint[] dataPoints = new DataPoint[progress.size()];

        for(int val : progress){
            dataPoints[count] = new DataPoint(count, val);
            count++;
        }
        LineGraphSeries<DataPoint> lineSeriesTest = new LineGraphSeries<>(dataPoints);
        linegraph.addSeries(lineSeriesTest);
    }

}