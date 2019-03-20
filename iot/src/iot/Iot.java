/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.util.ArrayList;

/**
 *
 * @author Amaury
 */
public class Iot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.insertNewMeasure(new ArrayList());
    }
    
}
