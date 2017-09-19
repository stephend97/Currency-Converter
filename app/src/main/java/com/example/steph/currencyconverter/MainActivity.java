package com.example.steph.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner fromSpinner;
    Spinner toSpinner;
    HashMap<String, Double> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = (Spinner) findViewById(R.id.inputSpinner);
        toSpinner = (Spinner) findViewById(R.id.outputSpinner);
        map = new HashMap<String, Double>();

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names2));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(myAdapter1);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(myAdapter2);

        addItems();
    }

    //converts the value based on the choices selected, toasts converted value
    public void buttonClick(View view){
        String fromText = fromSpinner.getSelectedItem().toString();
        String toText = toSpinner.getSelectedItem().toString();
        EditText num = (EditText) findViewById(R.id.enterNumEditText);

        double fromValue = map.get(fromText);
        double toValue = map.get(toText);
        double numEntered = Double.parseDouble(num.getText().toString());

        double convertedValue = numEntered*toValue*(1/fromValue);

        Toast.makeText(MainActivity.this, String.format("%.2f" ,convertedValue), Toast.LENGTH_SHORT).show();
    }

    //adds the currency type and conversion rate to the hashmap
    public void addItems(){
        map.put("Australian Dollar", 1.26);
        map.put("British Pound", .74);
        map.put("Euro", .84);
        map.put("Hong Kong Dollar", 7.82);
        map.put("Indian Rupee", 64.22);
        map.put("Japanese Yen", 111.44);
        map.put("Mexican Peso", 17.75);
        map.put("South Korean Won", 1129.88);
        map.put("United States Dollar", 1.0);
        map.put("Vietnamese Dong", 22726.5);
    }



}













