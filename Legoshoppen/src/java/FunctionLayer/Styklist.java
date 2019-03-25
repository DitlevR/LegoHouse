/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rumle
 */
public class Styklist {
    private int brick2x4;
    private int brick2x2;
    private int brick1x2;
  

    public Styklist(int brick2x4, int brick2x2, int brick1x2) {
        this.brick2x4 = brick2x4;
        this.brick2x2 = brick2x2;
        this.brick1x2 = brick1x2;
        
    }

    public int getBrick2x4() {
        return brick2x4;
    }

    public void setBrick2x4(int brick2x4) {
        this.brick2x4 = brick2x4;
    }

    public int getBrick2x2() {
        return brick2x2;
    }

    public void setBrick2x2(int brick2x2) {
        this.brick2x2 = brick2x2;
    }

    public int getBrick1x2() {
        return brick1x2;
    }

    public void setBrick1x2(int brick1x2) {
        this.brick1x2 = brick1x2;
    }

   

    @Override
    public String toString() {
        return "Styklist: " + "brick2x4: " + brick2x4 + " brick2x2: " + brick2x2 + " brick1x2: " + brick1x2;
    }

    
    

    
    
    
}
