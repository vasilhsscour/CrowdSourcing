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
        
//        initial values
        int turns;
        InitialShop init = new InitialShop();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> cityList = new HashSet<>();
        
        ArrayList<Shop> shopList = init.TakeLines();
        
//        find the different cities
        
        Implementation impl = new Implementation( shopList );
        
        impl.initCityList();

        impl.askForCity();

        impl.askForCategory();
       
        impl.askForShop();

        impl.askForResOrRev();
        
    }
}
