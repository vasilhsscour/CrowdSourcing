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
public class Shop {
    
    private String city;
    private String name;
    private String fullAdress;
    private String type;
    private String workingHour;
    private String workingDays;
    private int reviewCount;
    private int rating;
    private int maxReservations;

    public Shop(String city, String name, String fullAdress, String type, String workingHour, String workingDays, int reviewCount, int rating, int maxReservations) {
        this.city = city;
        this.name = name;
        this.fullAdress = fullAdress;
        this.type = type;
        this.workingHour = workingHour;
        this.workingDays = workingDays;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.maxReservations = maxReservations;
    }
    
    public Shop() {
        this.city = " ";
        this.name = " ";
        this.fullAdress = " ";
        this.type = " ";
        this.workingHour = " ";
        this.workingDays = " ";
        this.reviewCount = 0;
        this.rating = 0;
        this.maxReservations = 0;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAdress() {
        return fullAdress;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(String workingHour) {
        this.workingHour = workingHour;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMaxReservations() {
        return maxReservations;
    }

    public void setMaxReservations(int maxReservations) {
        this.maxReservations = maxReservations;
    }
    
    
    
    
}
