package com.thoughtworks.service.service;

import com.thoughtworks.service.enums.Stage;
import com.thoughtworks.service.models.Chemical;

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

    private Map<Integer, Queue> queues;
    private Map<Integer, Stage> processOrder;

    public ChemicalFactory() {
        this.grinderQueue = new LinkedList<>();
        this.mixerQueue = new LinkedList<>();
        this.reactorQueue = new LinkedList<>();
        this.packagerQueue = new LinkedList<>();
        this.cooler = new LinkedList<>();
        queues = new HashMap<>();
        processOrder = new HashMap<>();
    }

    public int process(Chemical... chemicals) {
        init(chemicals);

        int timePassed = 0;
        while (true) {
            if (processComplete()) {
                break;
            }
            timePassed++;
            for (int currentQueueIndex = 1; currentQueueIndex <= LAST_QUEUE_INDEX; currentQueueIndex++) {
                if (currentQueueIndex != COOLER_INDEX)
                    processQueue(currentQueueIndex, timePassed);
                else
                    processCoolerQueue(timePassed);
            }
        }
        return timePassed;
    }

    private void processCoolerQueue(int timePassed) {
        Queue<Chemical> coolerQueue = queues.get(COOLER_INDEX);
        for (Chemical chemical : coolerQueue) {
            if (chemical.getStageEntrytime() != timePassed && chemical.decrementAndReturnTimeInStage() == 0) {
                coolerQueue.remove();
                Queue<Chemical> nextQueue = queues.get(COOLER_INDEX + 1);
                nextQueue.add(chemical);
                chemical.updateStage(processOrder.get(COOLER_INDEX + 1), timePassed);
            }
        }

    }

    private boolean processComplete() {
        boolean complete = true;

        for (int currentQueueIndex = 1; currentQueueIndex <= LAST_QUEUE_INDEX; currentQueueIndex++) {
            if (!queues.get(currentQueueIndex).isEmpty()) {
                complete = false;
                break;
            }
        }
        return complete;
    }

    private void processQueue(int queueIndex, int time) {
        Queue<Chemical> currentQueue = queues.get(queueIndex);
        if (!currentQueue.isEmpty()) {

            Chemical chemical = currentQueue.peek();
            if (chemical.getStageEntrytime() != time && chemical.decrementAndReturnTimeInStage() == 0) {
                currentQueue.remove();
                if (queueIndex != LAST_QUEUE_INDEX) {
                    Queue<Chemical> nextQueue = queues.get(queueIndex + 1);
                    nextQueue.add(chemical);
                    chemical.updateStage(processOrder.get(queueIndex + 1), time);
                }
            }
        }
    }

    private void init(Chemical[] chemicals) {

        mapStageQueueOrder(Stage.GRINDER, 1, grinderQueue);
        mapStageQueueOrder(Stage.MIXER, 2, mixerQueue);
        mapStageQueueOrder(Stage.REACTOR, 3, reactorQueue);
        mapStageQueueOrder(Stage.COOLER, 4, cooler);
        mapStageQueueOrder(Stage.PACKAGER, 5, packagerQueue);


        for (Chemical chemical : chemicals) {
            chemical.updateStage(Stage.GRINDER, 0);
            grinderQueue.add(chemical);
        }

    }


    private void mapStageQueueOrder(Stage stage, int orderNo, Queue queue) {
        queues.put(orderNo, queue);
        processOrder.put(orderNo, stage);
    }


}
