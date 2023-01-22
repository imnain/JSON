package org.example;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URLConnection;

public class FetchJSON {

    public static void main(String[] args) throws IOException {
        String urlString = "https://dummyjson.com/products";
        URL url = new URL(urlString);
        URLConnection makeConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((makeConnection.getInputStream())));
        StringBuilder receiveResponse = new StringBuilder();
        String answer = "";
        while ((answer = bufferedReader.readLine()) != null) {
            receiveResponse.append(answer);
        }
        JSONObject jsonObject = new JSONObject(receiveResponse.toString());
        JSONArray products = jsonObject.getJSONArray("products");
        for (int i = 0; i < products.length(); i++) {
            JSONObject product = products.getJSONObject(i);
            String description = product.getString("description");
            System.out.println("Description: " + description);
        }
    }
}