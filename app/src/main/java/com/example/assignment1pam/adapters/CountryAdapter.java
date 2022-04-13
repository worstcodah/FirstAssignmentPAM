package com.example.assignment1pam.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment1pam.R;
import com.example.assignment1pam.activities.SecondActivity;
import com.example.assignment1pam.enums.DetailType;
import com.example.assignment1pam.models.Country;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {
    private ArrayList<Country> countryList;
    private DetailType detailType;

    public CountryAdapter(@NonNull Context context, int resource, ArrayList<Country> countryList, DetailType detailType) {
        super(context, resource, countryList);
        this.countryList = countryList;
        this.detailType = detailType;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        TextView continent = convertView.findViewById(R.id.continent);
        TextView capitalCity = convertView.findViewById(R.id.continent);
        TextView officialLanguage = convertView.findViewById(R.id.officialLanguage);
        TextView webUrl = convertView.findViewById(R.id.webUrl);
        ImageView imageView = convertView.findViewById(R.id.image);

        if (detailType == DetailType.MINIMUM) {
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());

        } else if (detailType == DetailType.MEDIUM) {
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());
            capitalCity.setText(countryList.get(position).getCapitalCity());
            officialLanguage.setText(countryList.get(position).getOfficialLanguage());
        } else {
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());
            capitalCity.setText(countryList.get(position).getCapitalCity());
            officialLanguage.setText(countryList.get(position).getOfficialLanguage());
            webUrl.setText(countryList.get(position).getWebUrl());
            imageView.setImageResource(countryList.get(position).getImageId());
        }
        return convertView;

    }
}
