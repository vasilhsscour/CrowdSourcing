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
public interface CheckForValidInputs {
    boolean checkForCities( String city );
    boolean checkForCategory( String city, String category );
    int checkForShop( String shop );
    boolean checkForRevOrRes( String resOrRev );
    boolean checkForName( String name );
    int checkForReview( String review );
    boolean checkForDay( String day );
    boolean checkForNumber( String phoneNumber );
}
