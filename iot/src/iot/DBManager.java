/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Amaury
 */
public class DBManager {
    
    
    public DBManager(){
        
    }
        
    public void insertNewMeasure(ArrayList data){
        JSONObject jsonObject = new JSONObject();
        
        JSONArray jsonArray = new JSONArray();
        
        for(int i = 1; i < 4; i++){
            //SensorMeasure
            JSONObject jsonSensorMeasure = new JSONObject();
            jsonSensorMeasure.put("mac", "12:34:56:78:"+i);
            jsonSensorMeasure.put("value", "1"+i+".5");
            jsonArray.put(jsonSensorMeasure);
        }
        //Adding to main json
        jsonObject.put("Measures", jsonArray);
        
        try {

            URL url = new URL("http://localhost:8080/add-data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonObject.toString().getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
            }
            
            conn.disconnect();

	} catch (Exception e) {
            e.printStackTrace();
	}
        
        System.out.println("json = " + jsonObject);
    }
}
