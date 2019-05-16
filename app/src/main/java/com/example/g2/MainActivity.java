package com.example.g2;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Graph laygraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        laygraph = findViewById(R.id.laygraph);

    List<Schedule> scheduleList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
        Schedule schedule = new Schedule();
        schedule.setDay(i);
        schedule.setStarttime(3.5f);
        schedule.setEndtime(8.5f);

        scheduleList.add(schedule);
    }


        laygraph.setSchedule(scheduleList);

}


}
