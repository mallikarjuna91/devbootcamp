package com.thoughtworks.service.models;

import com.thoughtworks.service.enums.Stage;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class Machine {
    Stage stage;
    Queue<Chemical> queue;



    public Machine(Stage stage){
        queue=new LinkedList<>();
    }
}
