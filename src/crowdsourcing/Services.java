/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vasilhs12
 */
public class Services {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private Shop shop = new Shop();

    public Services(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    
    
    public void Reservation () throws IOException {
        String input = null;
        
//       read by the user on the day he would like to make the reservation
        
        do {
            System.out.println("\nGive us the day of your reservation") ;
            input = br.readLine();
        }while ( !checkForValidDay( input ) );
       
//       end read

//       print the working hours nad the max reservations
       System.out.println("\nThe working hours is : " + this.shop.getWorkingHour() + "\nThe  max reservation is"+ this.shop.getMaxReservations());
//       if there is availability
//       read by the user FIRST AND LAST NAME
        do {
            System.out.println("\nGive us your first and last name") ;
            input = br.readLine();
        }while ( checkForValidName( input ) );
//       end read
        
//       read by the user phone number
       String phoneNumber;
        do {
            System.out.println("\nGive us your phone number ( XXX-XXX-XXXX )") ;
            phoneNumber = br.readLine();
            
        }while ( !checkForValidPhoneNumber(phoneNumber) );
//       end read
       
//       change the values maxReservation for this specific day
       this.shop.setMaxReservations(this.shop.getMaxReservations() -1);
        
    }
    
    public void Review () throws IOException {
//       read by the user FIRST AND LAST NAME
        String input = null;
        do {
            System.out.println("\nGive us your first and last name") ;
            input = br.readLine();
        }while (checkForValidName(input));
//       end read
       
//       read by the user for the Review of this shop
        
        int review;
        do {
            System.out.println("\nGive us your review");
            input = br.readLine();
            review = checkForValidReview(input);
        }while ( ( review < 0 ) || ( review > 5 ) );
       
       
//       end read
    
//       inform the review count and the rating
       int lastReviewCount = this.shop.getReviewCount();
       int lastRating = this.shop.getRating();
       int lastReviewSum = lastRating * lastReviewCount;
       int newReviewSum = lastReviewSum + review;
       int newReviewCount = lastReviewCount + 1;
       int newRating = newReviewSum / newReviewCount;
       
       System.out.println("last rating  " + lastRating +" and count " + lastReviewCount);
       System.out.println("new rating  " + newRating +" and count " + newReviewCount);
//       this.shop.setRating( Integer.parseInt(review));
    }
    
    public boolean checkForValidName( String name ) {
        
        if ( name.matches( "^[A-Za-z, ]++$" ) ) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public int checkForValidReview( String review ) {
       int check = 0;

        try {       
            check = Integer.parseInt(review);
        } catch (NumberFormatException e) {
            check = -1;
        }
        
        return check;
    }
    
    public boolean checkForValidPhoneNumber( String phone) {
        
        if ( phone.matches("\\d{3}-\\d{3}-\\d{4}") ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean checkForValidDay ( String day) {
        boolean returnState = false;
        switch ( day ) {
            case "Monday":
                returnState = true;
                break;
            case "Tuesday":
                returnState = true;
                break;
            case "Wednesday":
                returnState = true;
                break;
            case "Thursday":
                returnState = true;
                break;
            case "Friday":
                returnState = true;
                break;
            case "Saturday":
                returnState = true;
                break;
            case "Sunday":
                returnState = true;
                break;
            default:
                returnState = false;
                break;
        }
        
        return returnState;
    }
}
