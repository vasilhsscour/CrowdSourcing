/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsourcing;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vasilhs12
 */
public class InitialShop {
//    private ArrayList<Shop> shopList = new ArrayList<Shop>();
//    
//    public ArrayList<Shop> init() {
//        this.shopList.add(new Shop("","","","","","",0,0,0));
//        
//        return this.shopList;    
//    }
    
    private Scanner fileScanner; // creates a file

    public InitialShop() throws MalformedURLException, IOException {
        this.fileScanner = new Scanner(new File("C:\\Users\\vasilhs12\\Desktop\\Εργασίες\\Εργασία JAVA1\\px.csv"));
        
    }
    public void TakeLines() throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        
        while(fileScanner.hasNextLine() ){
            line = fileScanner.nextLine();
            System.out.println(line);
        }
        
    }
    
    
}
