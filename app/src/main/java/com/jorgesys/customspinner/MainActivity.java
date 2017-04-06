package com.jorgesys.customspinner;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String languages = "Python, C#, Java, Go, C++, Visual Basic, Objective-C, Swift, C";
        final List<String> listLanguages = new ArrayList<String>(Arrays.asList(languages.split(",")));
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        listLanguages.add(0, getResources().getString(R.string.language_type));

        SpinnerAdapter myAdapter = new SpinnerAdapter(getApplicationContext(), listLanguages);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {
                Snackbar snackbar = Snackbar
                        .make(arg1, "Language selected: " + listLanguages.get(pos), Snackbar.LENGTH_LONG);

                snackbar.show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }
}
