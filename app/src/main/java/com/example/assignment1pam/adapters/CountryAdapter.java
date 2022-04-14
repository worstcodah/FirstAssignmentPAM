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
import com.example.assignment1pam.constants.Constants;
import com.example.assignment1pam.enums.DetailType;
import com.example.assignment1pam.models.Country;
import com.squareup.picasso.Picasso;

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
        TextView capitalCity = convertView.findViewById(R.id.capitalCity);
        TextView officialLanguage = convertView.findViewById(R.id.officialLanguage);
        TextView webUrl = convertView.findViewById(R.id.webUrl);
        TextView nameLabel = convertView.findViewById(R.id.name_label);
        TextView continentLabel = convertView.findViewById(R.id.continent_label);
        TextView capitalCityLabel = convertView.findViewById(R.id.capital_label);
        TextView officialLanguageLabel = convertView.findViewById(R.id.language_label);
        TextView webUrlLabel = convertView.findViewById(R.id.web_label);
        ImageView imageView = convertView.findViewById(R.id.image);

        if (detailType == DetailType.MINIMUM) {
            switch (countryList.get(position).getName()) {
                case "Brazil":
                    imageView.setImageResource(R.drawable.brazil_flag);
                    break;
                case "Japan":
                    imageView.setImageResource(R.drawable.japan_flag);
                    break;
                case "France":
                    imageView.setImageResource(R.drawable.france_flag);
                    break;
            }
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());
            capitalCityLabel.setText("");
            officialLanguageLabel.setText("");
            webUrlLabel.setText("");

        } else if (detailType == DetailType.MEDIUM) {
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());
            capitalCity.setText(countryList.get(position).getCapitalCity());
            officialLanguage.setText(countryList.get(position).getOfficialLanguage());
            switch (countryList.get(position).getName()) {
                case "Brazil":
                    imageView.setImageResource(R.drawable.brazil_flag);
                    break;
                case "Japan":
                    imageView.setImageResource(R.drawable.japan_flag);
                    break;
                case "France":
                    imageView.setImageResource(R.drawable.france_flag);
                    break;
            }
            webUrlLabel.setText("");
        } else {
            name.setText(countryList.get(position).getName());
            continent.setText(countryList.get(position).getContinent());
            capitalCity.setText(countryList.get(position).getCapitalCity());
            officialLanguage.setText(countryList.get(position).getOfficialLanguage());
            webUrl.setText(countryList.get(position).getWebUrl());
            switch (countryList.get(position).getName()) {
                case "Brazil":
                    imageView.setImageResource(R.drawable.brazil_flag);
                    break;
                case "Japan":
                    imageView.setImageResource(R.drawable.japan_flag);
                    break;
                case "France":
                    imageView.setImageResource(R.drawable.france_flag);
                    break;
            }

        }
        return convertView;

    }
}
