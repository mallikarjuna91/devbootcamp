package com.thoughtworks.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by mallikarjuna on 5/30/16.
 */
public class SquareTest {

    @Test
    public void testArea() throws Exception {

    assertThat(new Square(5).area(),is(25.0));

    }
}