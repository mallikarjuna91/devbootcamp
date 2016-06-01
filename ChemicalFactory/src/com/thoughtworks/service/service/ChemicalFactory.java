package com.thoughtworks.service.service;

import com.thoughtworks.service.enums.MachineType;
import com.thoughtworks.service.models.Chemical;
import com.thoughtworks.service.models.Machine;

import javax.crypto.Mac;
import java.util.*;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class ChemicalFactory {

    public static final int COOLER_INDEX = 4;
    public static final int LAST_QUEUE_INDEX = 5;

    private Queue<Chemical> grinderQueue;
    private Queue<Chemical> mixerQueue;
    private Queue<Chemical> reactorQueue;
    private Queue<Chemical> packagerQueue;
    private LinkedList<Chemical> cooler;

    private Map<Integer, Machine> machines;


    public ChemicalFactory(int grinderCount, int mixerCount, int reactorCount, int packagerCount) {
        Machine grinder = new Machine(MachineType.GRINDER, grinderCount);
        Machine mixer = new Machine(MachineType.MIXER, mixerCount);
        Machine reactor = new Machine(MachineType.REACTOR, reactorCount);
        Machine packager = new Machine(MachineType.PACKAGER, packagerCount);
        Machine cooler = new Machine(MachineType.COOLER, 1);

        machines = new TreeMap<>();
        machines.put(1, grinder);
        machines.put(2, mixer);
        machines.put(3, reactor);
        machines.put(4, cooler);
        machines.put(5, packager);
    }

    public int process(Chemical... chemicals) {
        init(chemicals);

        int timePassed = 0;
        while (true) {


            for (int i : machines.keySet()) {
                Machine currentMachine = machines.get(i);
                List<Chemical> processedChemicals = currentMachine.getProcessedChemicals(timePassed);
                if (i != 5 && processedChemicals.size()!=0) {
                    machines.get(i + 1).addChemicals(processedChemicals);
                }
            }

            if (processComplete()) {
                break;
            }
            timePassed++;

        }
        return timePassed;
    }


    private boolean processComplete() {
        boolean complete = true;

        for (Machine machine : machines.values()) {
            if (!machine.isAvailable()) {
                complete = false;
                break;
            }
        }
        return complete;
    }


    private void init(Chemical[] chemicals) {
        Machine firstMachine = machines.get(1);
        for (Chemical chemical : chemicals) {
            firstMachine.addChemical(chemical);
        }

    }


}
