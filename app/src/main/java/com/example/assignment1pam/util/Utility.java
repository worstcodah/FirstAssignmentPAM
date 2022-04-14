package com.example.assignment1pam.util;

import com.example.assignment1pam.R;
import com.example.assignment1pam.models.Country;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Utility {
    public static ArrayList<Country> getCountries(InputStream is) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Country> countries = new ArrayList<>();
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document document = docBuilder.parse(is);

        NodeList countryNodeList = document.getElementsByTagName("country");
        String name = null, continent = null, officialLanguage = null, capitalCity = null, webUrl = null, imageUrl = null;

        for (int i = 0; i < countryNodeList.getLength(); i++) {

            NodeList countryNodes = countryNodeList.item(i).getChildNodes();
            name = countryNodes.item(1).getFirstChild().getTextContent();
            continent = countryNodes.item(3).getFirstChild().getTextContent();
            capitalCity = countryNodes.item(5).getFirstChild().getTextContent();
            officialLanguage = countryNodes.item(7).getFirstChild().getTextContent();
            webUrl = countryNodes.item(9).getFirstChild().getTextContent();
            imageUrl = countryNodes.item(11).getFirstChild().getTextContent();


            countries.add(new Country(name, continent, capitalCity, officialLanguage, webUrl, imageUrl));
        }

        return countries;
    }
}
