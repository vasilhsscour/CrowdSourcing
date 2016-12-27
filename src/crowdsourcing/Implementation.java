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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vasilhs12
 */
public class Implementation implements AskForInputs, CheckForValidInputs {

    private final BufferedReader br;
    private final ArrayList<Shop> shopList;
    private final Set<String> cityList;
    private final ArrayList<Shop> shopsByCategory;
    private final Customer customer;
    private String city ;
    private String category ;
    private int numOfShop ;
    private int review;

    public Implementation( ArrayList<Shop> shopList) {
        br = new BufferedReader(new InputStreamReader(System.in));
        this.shopList = shopList;
        this.cityList = new HashSet<>();
        this.shopsByCategory = new ArrayList<>();
        this.city = null;
        this.category = null;
        this.numOfShop = 0;
        this.review = -1;
        this.customer = new Customer();
    }
    
    private void initCityList () {
        for ( int turns=0;turns<this.shopList.size();turns++ ) {
            this.cityList.add(this.shopList.get(turns).getCity());
        }
        
        for (String c : cityList) { 
            System.out.println(c);
        }
    }
    
    public void modifyShop () {
        for (int i=0;i<shopList.size();i++) {
            if (shopList.get(i).getCity().equals(customer.getShop().getCity())) {
                shopList.get(i).setMaxReservations(customer.getShop().getMaxReservations());
                shopList.get(i).setReviewCount(customer.getShop().getReviewCount());
                shopList.get(i).setRating(customer.getShop().getRating());
            }
        }
    }   
    
//    ask and check for city input
    @Override
    public void askForCity() {
        this.initCityList();
        
        String city = null;
        do {
            try {
            System.out.println("\nChoose the city you like!");
                city = br.readLine();
            } catch (IOException ex) {
                System.out.println("Invalid Input!");
            }
            
        }while( checkForCities( city ) );
        
        this.city = city;
    }
    
    @Override
    public boolean checkForCities( String city ) {
        
        for (String s : cityList) {
            if ( s.equals(city)) {
                return false;
            }
        }
        
        return true;
    }
//    end for city input

//    ask and check for category input
    @Override
    public void askForCategory() {
        String category = null;
        do {
            try {
                System.out.println("\nChoose the category!");
                category = br.readLine();
            } catch (IOException ex) {
                System.out.println("Invalid Input!");
            }
            this.category = category;
            
        }while( checkForCategory( this.city, category ) );
    }

    @Override
    public boolean checkForCategory( String city, String category ) {
         boolean returnState = true;
        ArrayList<Shop> categoriesList = findShops( city, shopList );
        
        for ( int turns=0;turns<categoriesList.size();turns++) {
            if ( ( category.equals( categoriesList.get(turns).getCategories1() ) ) || ( category.equals( categoriesList.get(turns).getCategories0() ) ) ) {
                returnState = false;
            }
        }
        
        return returnState;
    }
    
    static ArrayList<Shop> findShops( String city, ArrayList<Shop> shopList ) {
        ArrayList<Shop> categoriesList = new ArrayList<>();
        
        for ( int turns=0; turns<shopList.size(); turns++ ) {
            if (city.equalsIgnoreCase( shopList.get( turns ).getCity() ) ) {
                categoriesList.add( shopList.get( turns ) );
            }
        }
        return categoriesList;
    }
    
    public void createCategoryList( ) {
        
        for ( int turns=0;turns<shopList.size();turns++) {
            if ( ( city.equalsIgnoreCase( shopList.get(turns).getCity() ) ) && ( category.equalsIgnoreCase( shopList.get(turns).getCategories1() ) ||  category.equalsIgnoreCase( shopList.get(turns).getCategories0() ) ) ) {
                this.shopsByCategory.add(shopList.get(turns));
            }
        }
    }
//    end for category input  
    
//    ask and check for shop input  
    @Override
    public void askForShop() {
        this.createCategoryList();
        
        if ( this.shopsByCategory.size() > 1 ) {
            
            for ( int turns=0;turns<shopsByCategory.size();turns++) {
                int temp = turns + 1;
                System.out.println("\n" + temp + ")The full address of the " + this.category 
                    + " you chose in " + this.city
                    + " is " + this.shopsByCategory.get(turns).getFullAdress()
                    + "\nAnd the review for this is : " + this.shopsByCategory.get(turns).getRating()
                    );
            }
            String number = null;
            do {
                try {
                    System.out.println("\nChoose one of the above stores! (Press 1,2,etc.)");
                    number = br.readLine();
                } catch (IOException ex) {
                    System.err.println("Invalid Input!");
                }
                this.numOfShop = checkForShop( number );
            }while ( ( this.numOfShop > this.shopsByCategory.size() ) || ( this.numOfShop <= 0 ) );
        }
        else {
            System.out.println("\nThe full address of the " + this.category 
                + " you chose in " + this.city
                + " is " + this.shopsByCategory.get(this.numOfShop).getFullAdress()
                + "\nAnd the review for this is : " + this.shopsByCategory.get(this.numOfShop).getRating()
            );
            this.numOfShop++;
        }
    }

    @Override
    public int checkForShop( String number) {
        int check = 0;

        try {       
            check = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            check = -1;
        }
        
        return check;
    }
//    end for shop input
    
//    ask and check for reservetion or review input      
    @Override
    public String askForResOrRev() {
        String resOrRev = null;
        do {
            System.out.println("\n\nYou would like to make a reservation or a review? (Press Reservation or Review !)");
            
            try {
                resOrRev = br.readLine();
            } catch (IOException ex) {
                System.err.println("Invalid Input!");
            }
            
        } while ( checkForRevOrRes( resOrRev ) );        
        
        Shop shop =  this.shopsByCategory.get( this.numOfShop - 1 );
        this.customer.setShop( shop );
        return resOrRev;
    }

    @Override
    public boolean checkForRevOrRes( String resOrRev) {
        if ( resOrRev.equals("Reservation") || resOrRev.equals("Review") ) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void informRev( Shop shop) {
        //       inform the review count and the rating
       int lastReviewCount = shop.getReviewCount();
       int lastRating = shop.getRating();
       int lastReviewSum = lastRating * lastReviewCount;
       int newReviewSum = lastReviewSum + this.review;
       int newReviewCount = lastReviewCount + 1;
       int newRating = newReviewSum / newReviewCount;
       
       System.out.println("last rating  " + lastRating +" and count " + lastReviewCount);
       System.out.println("new rating  " + newRating +" and count " + newReviewCount);
       shop.setRating(newRating);
       shop.setReviewCount(newReviewCount);
       this.customer.setShop(shop);
    }
//    end for reservetion or review input      
    
    
    
//    ask and check for firstName and lastName input      
    @Override
    public void askForName() {
        String input = null;
        do {
            try {
                System.out.println("\nGive us your first and last name") ;
                input = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Implementation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while ( checkForName( input ));
        this.customer.setFirstLastName(input);
    }

    @Override
    public boolean checkForName(String name) {
        if ( name.matches( "^[A-Za-z, ]++$" ) ) {
            return false;
        }
        else {
            return true;
        }
    }
//    end for firstName and lastName input  
    
//    ask and check for review input  
    @Override
    public void askForReview() {
        String input = null;
        int review = -1;
        do {
            try {
                System.out.println("\nGive us your review");
                input = br.readLine();
            } catch (IOException ex) {
                System.err.println("Invalid Input!");
            }
            review = checkForReview( input );
        }while ( ( review < 0 ) || ( review > 5 ) );
        this.review = review;
        this.customer.setReview(review);
    }

    @Override
    public int checkForReview( String review ) {
        int check;

        try {       
            check = Integer.parseInt(review);
        } catch (NumberFormatException e) {
            check = -1;
        }
        
        return check;
    }
//    end for review input  
    
//    ask and check for the day of reservation input      
    @Override
    public void askForDay() {
        String input = null;
        
//       read by the user on the day he would like to make the reservation
        
        do {
            try {
                System.out.println("\nGive us the day of your reservation") ;
                input = br.readLine();
            } catch (IOException ex) {
                System.err.println("Invalid Input!");
            }
        }while ( !checkForDay( input ) );
    }

    @Override
    public boolean checkForDay( String day ) {
        boolean returnState ;
        switch ( day ) {
            case "Monday":
                return true;
            case "Tuesday":
                return true;
            case "Wednesday":
                return true;
            case "Thursday":
                return true;
            case "Friday":
                return true;
            case "Saturday":
                return true;
            case "Sunday":
                return true;
            default:
                return false;
        }
    }
//    end for the day of reservation input          
    
//    ask and check for phone number input          
    @Override
    public void askForNumber() {
        String phoneNumber = null;
        do {
            try {
                System.out.println("\nGive us your phone number ( XXX-XXX-XXXX )") ;
                phoneNumber = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Implementation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }while ( !checkForNumber( phoneNumber ) );
        this.customer.setPhoneNumber(phoneNumber);
    }

    @Override
    public boolean checkForNumber( String phoneNumber) {
        if ( phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}") ) {
            return true;
        }
        else {
            return false;
        }
    }
//    end for phone number input      

    public Customer getCustomer() {
        return customer;
    }
    
    public void printAllData() {
        
        final Object[][] table = new String[25][];
        
        table[0] = new String[] { "city", "review_count", "rating", "name", "full_address", "type", "categories/0", "categories/1", "Working days", "working hours", "max_reservations" };
        
        for (int i=0;i<this.shopList.size();i++) {
            Shop shop = this.shopList.get(i);
            table[i+1] = new String[] { shop.getCity(), shop.getReviewCount()+"", shop.getRating()+"", shop.getName(), shop.getFullAdress(), shop.getType(), shop.getCategories0(), shop.getCategories1(), shop.getWorkingDays()+"", shop.getWorkingHour(), shop.getMaxReservations()+"" };
        }

        for (final Object[] row : table) {
            System.out.format("%30s\t%15s\t%15s\t%25s\t%80s\t%10s\t%30s\t%25s\t%20s\t%15s\t%20s\t\n", row);
        }
    }
    
    public int choose() throws IOException {
        int result = 0;
        do { 
            System.out.println("\n\nChoose one of the follow (1 or 2,etc.)");
            System.out.println("1)Choose a city");
            System.out.println("2)See all data");
            System.out.println("3)Exit");
            try {
                result = Integer.parseInt(br.readLine());
            }catch(NumberFormatException ex) {
                System.err.println("Invalid Input!");
                result = -1;
            }
        }while ( (result < 1) || ( result > 3) );
        
        return result;
    }
    
    
}