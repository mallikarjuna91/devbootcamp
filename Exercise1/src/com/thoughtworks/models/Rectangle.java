package com.thoughtworks.models;

/**
 * Created by mallikarjuna on 5/30/16.
 */
public class Rectangle {
    private double length;
    private double breadth;


    public Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;

    }

    public double area(){
        return length*breadth;
    }
}
