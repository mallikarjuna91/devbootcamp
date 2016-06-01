package com.thoughtworks.service.models;

import com.thoughtworks.service.enums.MachineType;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class Machine {
    MachineType machineType;
    Queue<Chemical> queue;
    int count;



    List<Chemical> processingChemicals;

    public Machine(MachineType machineType, int count) {
        queue = new LinkedList<>();
        this.machineType = machineType;
        this.count = count;
        this.processingChemicals = new ArrayList<>();
    }

    public List<Chemical> getProcessedChemicals(int startTime) {

        List<Chemical> processedChemicals = new ArrayList<>();

        for (int j = processingChemicals.size()-1; j >= 0; j--) {
            Chemical chemical = processingChemicals.get(j);
            if (startTime!=chemical.getStageEntrytime() && chemical.decrementAndReturnTimeInStage() == 0) {
                processedChemicals.add(chemical);
                processingChemicals.remove(j);
            }
        }

        while (!queue.isEmpty() && (machineType== MachineType.COOLER || processingChemicals.size()!=count)){

            Chemical chemical=queue.remove();
            chemical.updateStage(machineType, startTime);
            processingChemicals.add(chemical);
        }

        return processedChemicals;
    }

    public void addChemicals(List<Chemical> chemicals) {
        queue.addAll(chemicals);
    }

    public void addChemical(Chemical chemical) {
        queue.add(chemical);
    }

    public boolean isAvailable(){
        return  queue.size()==0 && processingChemicals.size()==0;
    }
}
