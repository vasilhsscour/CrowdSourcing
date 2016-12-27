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
public class Customer {
    private String FirstLastName;
    private String phoneNumber;
    private int review;
    private Shop shop;

    public Customer() {
        this.FirstLastName = " ";
        this.phoneNumber = " ";
        this.review = -1;
        this.shop = null;
    }

    public String getFirstLastName() {
        return FirstLastName;
    }

    public void setFirstLastName(String FirstLastName) {
        this.FirstLastName = FirstLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    
    
    
}
