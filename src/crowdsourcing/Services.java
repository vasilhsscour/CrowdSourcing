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
    
    static final int STRING = 1;
    static final int INTEGER = 0;
    
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
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
    
    
    
    public void Reservation () {
       System.out.println("Give us the day of your reservation") ;
//       read by the user on the day he would like to make the reservation
       
//       end read

//       print the working hours nad the max reservations
       System.out.println("The working hours is : " + this.shop.getWorkingHour() + "\nThe  max reservation is"+ this.shop.getMaxReservations());
//       if there is availability
       System.out.println("Give us your first/last name") ;
//       read by the user FIRST AND LAST NAME
       
//       end read
       System.out.println("Give us your phone number") ;
//       read by the user phone number
       
//       end read
       
//       change the values maxReservation for this specific day
       this.shop.setMaxReservations(this.shop.getMaxReservations() -1);
        
    }
    
    public void Review () throws IOException {
       System.out.println("Give us your first and last name") ;
       
//       read by the user FIRST AND LAST NAME
       
//       end read
       
       System.out.println("Give us your review");
       
//       read by the user for the Review of this shop
       
//       end read
    
//       inform the review count and the rating
       this.shop.setReviewCount(this.shop.getReviewCount() +1);
//       this.shop.setRating( Integer.parseInt(review));
    }
    
    public int checkForValidInput(Object obj) {
        if ( obj instanceof Integer ) {
            return INTEGER;
         }
        else {
            return STRING;
        }
    }
}
