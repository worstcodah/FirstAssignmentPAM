package com.example.assignment1pam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.assignment1pam.R;
import com.example.assignment1pam.adapters.CountryAdapter;
import com.example.assignment1pam.enums.DetailType;
import com.example.assignment1pam.models.Country;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FirstActivity extends AppCompatActivity {

    private final ArrayList<Country> countries = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            populateCountryList();
            CountryAdapter countryAdapter = new CountryAdapter(getBaseContext(), R.layout.item_country, countries, DetailType.MINIMUM);
            ListView listView = findViewById(R.id.first_lv);
            listView.setAdapter(countryAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
            });

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private void populateCountryList() throws ParserConfigurationException, IOException, SAXException {
        InputStream is = getResources().openRawResource(R.raw.countries);
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document document = docBuilder.parse(is);

        NodeList countryNodeList = document.getElementsByTagName("country");
        String name = null, continent = null, officialLanguage = null, capitalCity = null, webUrl = null;
        int imageId = 0;

        for (int i = 0; i < countryNodeList.getLength(); i++) {

            NodeList countryNodes = countryNodeList.item(i).getChildNodes();
            name = countryNodes.item(1).getFirstChild().getTextContent();
            continent = countryNodes.item(3).getFirstChild().getTextContent();
            capitalCity = countryNodes.item(5).getFirstChild().getTextContent();
            officialLanguage = countryNodes.item(7).getFirstChild().getTextContent();
            webUrl = countryNodes.item(9).getFirstChild().getTextContent();
            imageId = Integer.parseInt(countryNodes.item(11).getFirstChild().getTextContent());
            /*
            for (int j = 0; j < countryNodes.getLength(); j++) {
                Node country = countryNodes.item(j);
                String localName = country.getLocalName().toString();
                if (localName != null) {
                    if (localName.equals("name")) {
                        name = countryNodes.item(j).getFirstChild().getTextContent();
                    } else if (localName.equals("continent")) {
                        continent = countryNodes.item(j).getFirstChild().getTextContent();
                    } else if (localName.equals("officialLanguage")) {
                        officialLanguage = countryNodes.item(j).getFirstChild().getTextContent();
                    } else if (localName.equals("capitalCity")) {
                        capitalCity = countryNodes.item(j).getFirstChild().getTextContent();
                    } else if (localName.equals("webUrl")) {
                        webUrl = countryNodes.item(j).getFirstChild().getTextContent();
                    } else if (localName.equals("imageId")) {
                        imageId = Integer.parseInt(countryNodes.item(j).getFirstChild().getTextContent());
                    }
                }
            }

             */

            countries.add(new Country(name, continent, capitalCity, officialLanguage, webUrl, imageId));
        }
    }


}