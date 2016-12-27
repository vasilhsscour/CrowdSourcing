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
        int turns = 0;
        InitialShop init = new InitialShop();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> cityList = new HashSet<>();
        
        ArrayList<Shop> shopList = init.TakeLines();
        
//        find the different cities
        
        Implementation impl = new Implementation( shopList );
        
        int result = 0;
        
        
        do {
            result = impl.choose();
            if ( result == 1) {
                impl.askForCity();
                impl.askForCategory();
                impl.askForShop();

                String resOrRev = impl.askForResOrRev();
                Shop shop = impl.getCustomer().getShop();

                if ( resOrRev.equals( "Reservation" ) ) {

                    impl.askForDay();
                    System.out.println("\nThe working hours is : " + shop.getWorkingHour() + "\nThe  max reservation is : "+ shop.getMaxReservations());

                    if (shop.getMaxReservations() != 0) {
                        impl.askForName();
                        impl.askForNumber();
                        System.out.println("last max reservation  " + shop.getMaxReservations());
                        shop.setMaxReservations(shop.getMaxReservations() -1);
                        System.out.println("new max reservation  " + shop.getMaxReservations());
                        impl.getCustomer().setShop(shop);
                        impl.modifyShop();
                    }
                    else {
                        System.err.println("\n\nNo available reservation for that day!\n");
                        impl.askForCity();
                    }

                }
                else {
                    impl.askForName();
                    impl.askForReview();
                    impl.informRev( shop );
                    impl.modifyShop();
                }
            }
            else if (result == 2) {
                impl.printAllData();
            }
            else {
                System.out.println("Bye Bye!");
            }
        } while (result != 3);
    }
}
