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
    private int reviewCount;
    private int rating;
    private String name;
    private String fullAdress;
    private String type;
    private String categories0;
    private String categories1;
    private int workingDays;
    private String workingHour;
    private int maxReservations;

    public Shop(String city, int reviewCount, int rating, String name, String fullAdress, String type, String categories0, String categories1, int workingDays, String workingHour, int maxReservations) {
        this.city = city;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.name = name;
        this.fullAdress = fullAdress;
        this.type = type;
        this.categories0 = categories0;
        this.categories1 = categories1;
        this.workingDays = workingDays;
        this.workingHour = workingHour;
        this.maxReservations = maxReservations;
    }

    public Shop() {
        this.city = " ";
        this.reviewCount = 0;
        this.rating = 0;
        this.name = " ";
        this.fullAdress = " ";
        this.type = " ";
        this.categories0 = " ";
        this.categories1 = " ";
        this.workingDays = 0;
        this.workingHour = " ";
        this.maxReservations = 0;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategories0(String categories0) {
        this.categories0 = categories0;
    }

    public void setCategories1(String categories1) {
        this.categories1 = categories1;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public void setWorkingHour(String workingHour) {
        this.workingHour = workingHour;
    }

    public void setMaxReservations(int maxReservations) {
        this.maxReservations = maxReservations;
    }

    public String getCity() {
        return city;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getFullAdress() {
        return fullAdress;
    }

    public String getType() {
        return type;
    }

    public String getCategories0() {
        return categories0;
    }

    public String getCategories1() {
        return categories1;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public String getWorkingHour() {
        return workingHour;
    }

    public int getMaxReservations() {
        return maxReservations;
    }
    
    @Override
    public String toString() {
        return  city + " \t " + reviewCount + " \t " + rating + " \t " + name + " \t " + fullAdress + " \t " + type + " \t " + categories0 + " \t " + categories1 + "\t " + workingDays + "\t " + workingHour + "\t " + maxReservations;
    }
    
    

    
}
