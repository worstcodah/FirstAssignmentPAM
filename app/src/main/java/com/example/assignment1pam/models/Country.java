package com.example.assignment1pam.models;

public class Country {
    private String name;
    private String continent;
    private String capitalCity;
    private String officialLanguage;
    private String webUrl;
    private String imageUrl;

    public Country(String name, String continent, String capitalCity, String officialLanguage, String webUrl, String imageUrl) {
        this.name = name;
        this.continent = continent;
        this.capitalCity = capitalCity;
        this.officialLanguage = officialLanguage;
        this.webUrl = webUrl;
        this.imageUrl = imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

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
}
