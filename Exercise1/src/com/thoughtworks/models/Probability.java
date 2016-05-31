package com.thoughtworks.models;

import java.nio.file.ProviderNotFoundException;

/**
 * Created by mallikarjuna on 5/30/16.
 */
public class Probability {


    double chance;

    public Probability(double v) {
    this.chance =v;
    }

    public Probability negate() {
        return new Probability(1.0 - chance);
    }


    public Probability and(Probability probability) {

        return new Probability(chance * probability.chance);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if (Double.compare(Math.round(that.chance),Math.round(chance)) !=  0) return false;

        return true;
    }

    @Override
    public int hashCode() {

        return 1;
    }


    public Probability or(Probability that) {

        double probSum=this.chance+that.chance;
        Probability result=new Probability(probSum - and(that).chance);
        return result;
    }
}
