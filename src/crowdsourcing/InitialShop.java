/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vasilhs12
 */
public class InitialShop {
    
    private final BufferedReader fileScanner; // creates a file
    private Shop shop;
    private ArrayList<Shop> shopList;

    public InitialShop() throws MalformedURLException, IOException {
        fileScanner = new BufferedReader(new FileReader("C:\\Users\\vasilhs12\\Desktop\\file.csv"));
        shopList = new ArrayList<Shop>();
    }
    public ArrayList<Shop> TakeLines() throws IOException {
        String line;
        String[] splitLines = null;
        
        int j = 0;
        while((line = fileScanner.readLine()) != null ){
            
            splitLines = line.split(",");
            
            if ( j !=0 ) {
                shop = new Shop(splitLines[0],Integer.parseInt(splitLines[1]),Integer.parseInt(splitLines[2]),splitLines[3],splitLines[4] + ", " + splitLines[5],splitLines[6],splitLines[7],splitLines[8],Integer.parseInt(splitLines[9]),splitLines[10],Integer.parseInt(splitLines[11]));
                shopList.add(shop);
            }
            
            j++;
        }
        
        return shopList;
        
    }
    
    
}
