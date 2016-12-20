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
        
//        initial values
        int turns;
        InitialShop init = new InitialShop();
        ArrayList<Shop> shopList = new ArrayList<Shop>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> cityList = new HashSet<String>();
        
        shopList = init.TakeLines();
        
//        find the different cities
        for ( turns=0;turns<shopList.size();turns++ ) {
            cityList.add(shopList.get(turns).getCity());
        }
        
//        displays the user the cities
        for (String city : cityList) {
            System.out.println(city);
        }
        
//        asks the user the city who are interested and checking for valid input
        String city = null;
        do {
            System.out.println("\nChoose the city you like!");
            city = br.readLine();
            
        }while (checkForValidCity(city,cityList));
        
//        asks the user the category who are interested and checking for valid input
        String category = null;
        do {
            System.out.println("\nChoose the category!");
            category = br.readLine();
            
        }while (checkForValidCategory(city,category,shopList));
        
        
        
//        displays the user the full address and the review
        ArrayList<Shop> tempList = new ArrayList<Shop>();
        
        for ( turns=0;turns<shopList.size();turns++) {
            if ( ( city.equalsIgnoreCase( shopList.get(turns).getCity() ) ) && ( category.equalsIgnoreCase( shopList.get(turns).getCategories1() ) ||  category.equalsIgnoreCase( shopList.get(turns).getCategories0() ) ) ) {
                tempList.add(shopList.get(turns));
            }
        }
        
//        check if he found more than one results
//        if it has found the results are displayed in the user profile and ask to pick one
//        when picked checks if isinvalid
//        if only one result displays the user without putting him chosen        
        int numOfShop = 0;
        if ( tempList.size() > 1 ) {
            
            for ( turns=0;turns<tempList.size();turns++) {
                int temp = turns + 1;
                System.out.println( 
                    "\n" + temp + ")The full address of the " + category 
                    + " you chose in " + city
                    + " is " + tempList.get(turns).getFullAdress()
                    + "\nAnd the review for this is : " + tempList.get(turns).getRating()
                    );
            }
            String number = null;
            do {
                System.out.println("\nChoose one of the above stores! (Press 1,2,etc.)");
                number = br.readLine();
                numOfShop = checkForInteger(number);
            }while ( ( numOfShop > tempList.size() ) || ( numOfShop <= 0 ) );
        }
        else {
            numOfShop++;
            System.out.println(
                "\nThe full address of the " + category 
                + " you chose in " + city
                + " is " + tempList.get(0).getFullAdress()
                + "\nAnd the review for this is : " + tempList.get(0).getRating()
            );
        }
        
        
//      asks user if he wants to make reservation or review
        String service = null;
        do {
            System.out.println("\n\nYou would like to make a reservation or a review? (Press Reservation or Review !)");
            
            service = br.readLine();
            
        } while ( checkForService(service) );        
        
        Services services = new Services(tempList.get(numOfShop -1));
        
        if ( service.equals( "Reservation" ) ) {
            services.Reservation();
        }
        else {
            services.Review();
        }
    }
    
//    checks if the user has provided correct entrance to the city
    static boolean checkForValidCity(String city, Set<String> cityList) {
        boolean returnState = true;
        
        for (String s : cityList) {
            if ( s.equals(city)) {
                returnState = false;
                break;
            }
        }
        
        return returnState;
        
    }
    
//    checks if the user has provided correct entrance to the categories
    static boolean checkForValidCategory( String city, String category, ArrayList<Shop> shopList ) {
        boolean returnState = true;
        ArrayList<Shop> categoriesList = new ArrayList<Shop>();
        
        categoriesList = findShops ( city, shopList );
        
        for ( int turns=0;turns<categoriesList.size();turns++) {
            if ( ( category.equals( categoriesList.get(turns).getCategories1() ) ) || ( category.equals( categoriesList.get(turns).getCategories0() ) ) ) {
                returnState = false;
            }
        }
        
        return returnState;
    }
    
//    finds the shops for a city
    static ArrayList<Shop> findShops( String city, ArrayList<Shop> shopList ) {
        ArrayList<Shop> categoriesList = new ArrayList<Shop>();
        
        for ( int turns=0;turns<shopList.size();turns++) {
            if (city.equalsIgnoreCase(shopList.get(turns).getCity())) {
                categoriesList.add(shopList.get(turns));
            }
        }
        
        return categoriesList;
    }
    
//    check if an integer
//    if it returns the integer or otherwise returns -1
    static public int checkForInteger(String number) {
        int check = 0;

        try {       
            check = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            check = -1;
        }
        
        return check;
    }
    
    static public boolean checkForService(String service) {
        if ( service.equals("Reservation") || service.equals("Review") ) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
}
