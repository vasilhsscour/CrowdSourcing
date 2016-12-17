/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

/**
 *
 * @author vasilhs12
 */
public class Services {
    
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
       System.out.println("The working hours is : " + this.shop.getWorkingHour() + "\nThe  max reservation is"+ this.shop.getMaxReservations());
//       if there is availability
       System.out.println("Give us your first/last name") ;
//       read by the user FIRST AND LAST NAME
       System.out.println("Give us your phone number") ;
//       read by the user phone number
       this.shop.setMaxReservations(this.shop.getMaxReservations() -1);
        
    }
    
    public void Review () {
       System.out.println("Give us your first and last name") ;
       
//       read by the user FIRST AND LAST NAME
       
       System.out.println("Give us your review");
       
//       read by the user for the Review of this shop
       int review = 0;
//       inform the review count and the rating
       this.shop.setReviewCount(this.shop.getReviewCount() +1);
       this.shop.setRating((this.shop.getRating()*this.shop.getReviewCount() + review) / this.shop.getReviewCount());
    }
    
}
