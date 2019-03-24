/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import static FunctionLayer.LogicFacade.login;
import PresentationLayer.LegoHouse;
import PresentationLayer.User;

/**
 *
 * @author Rumle
 */
public class BrickCalculator {
    public static Styklist getStyklist(LegoHouse house) throws HouseException {
     int brick2x4 = 0;
     int brick2x2 = 0;
     int brick1x2 = 0;
     int window2x2 = 0;
     int door3x2 = 0;
     int lengthleft = 0;
     int widthleft = 0;
        
        
        int length = house.getLength();
        int width = house.getWidth();
        int height = house.getHeight();
                
        if(length < 5 || width < 5) {
            throw new HouseException("house is too small");
        }
        
        
     
        brick2x4 = (length - (length%4)) / 4;
        length = length - (brick2x4 * 4);
        
        if(length != 0) {
            brick2x2 = (length - (length%2)) / 2;
            length = length - (brick2x2 * 2);
        }
        
        if(length != 0) {
            brick1x2 = (length - (length%1)) / 1;
            length = length - (brick1x2 * 1);
        }
        
        
        
        brick2x4 = (width - (width%4)) / 4;
        width = width - (brick2x4 * 4);
        
        if(width != 0) {
            brick2x2 = (width - (width%2)) / 2;
            width = width - (width * 2);
        }
        
        if(width != 0) {
            brick1x2 = (width - (width%1)) / 1;
            width = width - (brick1x2 * 1);
        }
        brick1x2 += brick1x2 *2;
        brick2x2 += brick2x2 *2;
        brick2x4 += brick2x4 *2;
        
        
        
        
        Styklist order = new Styklist(brick2x4, brick2x2, brick1x2, window2x2, door3x2);
        
        
        return order;
                
            
    }
    
    
    
    public static void main(String[] args) throws HouseException, LoginSampleException {
        User user = login("someone@nowhere.com", "sesam");
        LegoHouse house = new LegoHouse(0 ,user.getId(), 5, 5, 1, false);
        System.out.println(getStyklist(house).toString());
    }
    
}
