package edu.ap.jaxrs;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 

import javax.json.Json;
import javax.json.JsonObject;

public class JsonReader {
	public static final String JSON_FILE="Product.json";
    
    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream(JSON_FILE);
         
        //create JsonReader object
        javax.json.JsonReader jsonReader = Json.createReader(fis);
         
        /**
         * We can create JsonReader from Factory also
        JsonReaderFactory factory = Json.createReaderFactory(null);
        jsonReader = factory.createReader(fis);
        */
         
        //get JsonObject from JsonReader
       JsonObject jsonObject = jsonReader.readObject();
         
        //we can close IO resource and JsonReader now
        jsonReader.close();
        fis.close();
         
        //Retrieve data from JsonObject and create Json format bean
        Product emp = new Product();
         
        emp.setId(jsonObject.getInt("id"));
        emp.setShortname(jsonObject.getString("name"));
        emp.setBrand(jsonObject.getString("brand"));
        emp.setDescription(jsonObject.getString("description"));
        emp.setPrice(jsonObject.getInt("price"));
         
        
        /*reading inner object from json object
        JsonObject innerJsonObject = jsonObject.getJsonObject("Product");
        Product product = new Product();
        product.getId(innerJsonObject.);
        address.setCity(innerJsonObject.getString("city"));
        address.setZipcode(innerJsonObject.getInt("zipcode"));
        emp.setAddress(address);
         */
        //print employee bean information
        System.out.println(emp);
         
    }
	

}
