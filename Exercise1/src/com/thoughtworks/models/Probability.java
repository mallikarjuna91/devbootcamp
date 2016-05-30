package com.thoughtworks.models;

/**
 * Created by mallikarjuna on 5/30/16.
 */
public class Probability {


    double probabilityValue;

    public Probability(double v) {
    this.probabilityValue=v;
    }

    public Probability negate() {
        return new Probability(1.0 - probabilityValue);
    }

    public double getProbabliltyValue(){
        return probabilityValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if (Double.compare(Math.round(that.probabilityValue),Math.round(probabilityValue)) !=  0) return false;

        return true;
    }

    @Override
    public int hashCode() {

        return 1;
    }
}
