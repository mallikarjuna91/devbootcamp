package com.thoughtworks.service.models;

import com.thoughtworks.service.enums.ChemicalType;
import com.thoughtworks.service.enums.Stage;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class Chemical {

    public ChemicalType getType() {
        return type;
    }

    ChemicalType type;
    Stage currentStage;

    int remainingTimeinStage;

    public int getStageEntrytime() {
        return stageEntrytime;
    }

    int stageEntrytime;

    public Chemical(ChemicalType type) {
        this.type = type;

    }


    public void updateStage(Stage stage,int entryTime) {
        this.currentStage=stage;
        this.stageEntrytime=entryTime;
        this.remainingTimeinStage=type.getTimeInStage(currentStage);
    }

    public int decrementAndReturnTimeInStage() {
        this.remainingTimeinStage--;
        return this.remainingTimeinStage;
    }


}
