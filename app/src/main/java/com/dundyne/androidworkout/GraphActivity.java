package com.dundyne.androidworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    GraphView linegraph;
    TinyDB tinydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        tinydb = new TinyDB(getApplicationContext());
        linegraph = (GraphView) findViewById(R.id.line_graph);

       createGraph();

    }

    public void createGraph(){

        int count = 0;
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