package com.example.assignment1pam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.assignment1pam.R;
import com.example.assignment1pam.models.Country;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent intent = getIntent();
        WebView webView = findViewById(R.id.fourth_wv);
        webView.loadUrl(intent.getStringExtra("webUrl"));
    }
}