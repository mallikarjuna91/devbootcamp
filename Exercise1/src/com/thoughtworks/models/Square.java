package com.thoughtworks.models;

/**
 * Created by mallikarjuna on 5/30/16.
 *
 *
 * Job of this class is to  represent the square,
 * it inherits the rectangle class( Since  a square is a rectange with equal length and breadth).
 * It takes only side of the square .
 *
 */
public class Square extends Rectangle{

    public  Square(double side){
        super(side,side);
    }

}
