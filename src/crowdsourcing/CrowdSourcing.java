/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vasilhs12
 */
public class CrowdSourcing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        InitialShop init = new InitialShop();
        ArrayList<Shop> shopList = new ArrayList<Shop>();
        
        shopList = init.TakeLines();
      
        Services services = new Services(shopList.get(1));
        
        services.Review();
        services.Reservation();
    }
    
}
