package com.thoughtworks.models;

import org.junit.Test;

import java.nio.file.ProviderNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by mallikarjuna on 5/30/16.
 */
public class ProbababilityTest {
    @Test
    public void testNegation() {
        assertThat(new Probability(0.8).negate(),is(new Probability(0.2)));
    }


    @Test
    public void testAnd()  {
        assertThat(new Probability(0.5).and(new Probability(0.5)),is(new Probability(0.25)));
    }



    @Test
    public void testOr() {
        assertThat(new Probability(0.5).or(new Probability(0.5)),is(new Probability(0.75)));
        assertThat(new Probability(1).or(new Probability(1)),is(new Probability(1)));
        assertThat(new Probability(0).or(new Probability(1)),is(new Probability(1)));
    }

    @Test
    public void testEquality() {

        Probability p1=new Probability(0.2);
        assertThat(new Probability(0.2),is(p1));

        Probability p2=new Probability(0.2);
        assertThat(p1,is(p2));
        assertThat(p2,is(p1));

        Probability p3=new Probability(0.2);
        assertThat(p1,is(p2));
        assertThat(p2,is(p3));
        assertThat(p3,is(p1));
    }
}
