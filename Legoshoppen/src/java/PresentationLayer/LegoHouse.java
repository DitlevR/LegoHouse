/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;


import java.sql.Date;

/**
 *
 * @author Rumle
 */
public class LegoHouse {
   private int order_id;
    private int user_id;
   private int length;
   private int width;
   private int height;
   private boolean shipped;

    public LegoHouse(int order_id, int user_id, int length, int width, int height, boolean shipped) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shipped = shipped;
    }

    public LegoHouse(int user_id, int length, int width, int height, boolean shipped) {
        this.user_id = user_id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shipped = shipped;
    }
    
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "order_id: " + order_id + ", user_id: " + user_id + ", length: " + length + ", width: " + width + ", height: " + height + ", shipped=" + shipped + "\n";
    }

    

}
