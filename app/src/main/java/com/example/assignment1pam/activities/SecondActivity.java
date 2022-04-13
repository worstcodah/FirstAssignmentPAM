package com.example.assignment1pam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.assignment1pam.R;
import com.example.assignment1pam.adapters.CountryAdapter;
import com.example.assignment1pam.enums.DetailType;
import com.example.assignment1pam.models.Country;
import com.example.assignment1pam.util.Utility;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

public class SecondActivity extends AppCompatActivity {
    private ArrayList<Country> countries = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try {
            this.countries = Utility.getCountries(getResources().openRawResource(R.raw.countries));
            CountryAdapter countryAdapter = new CountryAdapter(getBaseContext(), R.layout.item_country, countries, DetailType.MEDIUM);
            ListView listView = findViewById(R.id.second_lv);
            listView.setAdapter(countryAdapter);
            listView.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            });

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}