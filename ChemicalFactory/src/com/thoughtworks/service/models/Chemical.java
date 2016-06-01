package com.thoughtworks.service.models;

import com.thoughtworks.service.enums.ChemicalType;
import com.thoughtworks.service.enums.MachineType;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class Chemical {

    public ChemicalType getType() {
        return type;
    }

    ChemicalType type;
    MachineType currentMachineType;

    int remainingTimeinStage;

    public int getStageEntrytime() {
        return stageEntrytime;
    }

    int stageEntrytime;

    public Chemical(ChemicalType type) {
        this.type = type;

    }


    public void updateStage(MachineType machineType, int entryTime) {
        this.currentMachineType = machineType;
        this.stageEntrytime=entryTime;
        this.remainingTimeinStage=type.getTimeInStage(currentMachineType);
    }

    public int decrementAndReturnTimeInStage() {
        this.remainingTimeinStage--;
        return this.remainingTimeinStage;
    }


}
