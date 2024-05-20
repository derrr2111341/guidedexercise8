package com.example.guidedexercise8;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner names;
    TextView result;
    ArrayAdapter<String> adapter;
    String[] listOfNames = {"Name Here", "Papsi", "Pol", "Che", "Tin",
            "Renz", "Lou", "Chan", "Ven", "Jher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        names = findViewById(R.id.spnrNamesGE8);
        result = findViewById(R.id.tvResultGE8);

        // Initialize ArrayAdapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfNames);

        // Set up spinner and item selection listener
        showSelectedName();
    }

    public void showSelectedName(){
        names.setAdapter(adapter);
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0){
                    result.setText("Name: " + listOfNames[i]);
                    Toast.makeText(getApplicationContext(),
                            "Name: " + listOfNames[i], Toast.LENGTH_SHORT).show();
                } else {
                    result.setText("Name: ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}