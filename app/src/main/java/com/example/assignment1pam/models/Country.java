package com.example.assignment1pam.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    private String name;
    private String continent;
    private String capitalCity;
    private String officialLanguage;
    private String webUrl;

    public Country(String name, String continent, String capitalCity, String officialLanguage, String webUrl) {
        this.name = name;
        this.continent = continent;
        this.capitalCity = capitalCity;
        this.officialLanguage = officialLanguage;
        this.webUrl = webUrl;
    }


    protected Country(Parcel in) {
        name = in.readString();
        continent = in.readString();
        capitalCity = in.readString();
        officialLanguage = in.readString();
        webUrl = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getContinent() {
        return continent;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setOfficialLanguage(String officialLanguage) {
        this.officialLanguage = officialLanguage;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(continent);
        parcel.writeString(capitalCity);
        parcel.writeString(officialLanguage);
        parcel.writeString(webUrl);
    }
}
