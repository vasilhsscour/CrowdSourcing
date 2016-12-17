/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vasilhs12
 */
public class CrowdSourcing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InitialShop init = new InitialShop();
        ArrayList<Shop> shopList = new ArrayList<Shop>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        shopList = init.TakeLines();
      
        Services services = new Services(shopList.get(1));
        
        Set<String> cityList = new HashSet<String>();
        
        for (int i=0;i<shopList.size();i++) {
            cityList.add(shopList.get(i).getCity());
        }
        
        for (String s : cityList) {
            System.out.println(s);
        }
        
        
        String city = null;
        do {
            System.out.println("Choose the city you like!");
            city = br.readLine();
            
        }while (checkForValidCity(city,cityList));
       
        
//        services.Review();
//        services.Reservation();
    }
    
    static boolean checkForValidCity(String city, Set<String> cityList) {
        boolean returnState = true;
        for (String s : cityList) {
            if ( s.equalsIgnoreCase(city)) {
                returnState = false;
                break;
            }
        }
        
        return returnState;
        
    }
    
}
