package com.thoughtworks.service.enums;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public enum ChemicalType {
    CHEMICALX(3, 3, 1, 2, 1),
    CHEMICALY(1, 1, 2, 2, 1),
    CHEMICALZ(3, 3, 3, 1, 1);


    private final int g;
    private final int m;
    private final int r;
    private final int c;
    private final int p;

    ChemicalType(int g, int m, int r, int c, int p) {

        this.g = g;
        this.m = m;
        this.r = r;
        this.c = c;
        this.p = p;
    }

    public int getTimeInStage(Stage stage) {

        switch (stage) {
            case GRINDER:
                return g;
            case MIXER:
                return m;
            case REACTOR:
                return r;
            case COOLER:
                return c;
            case PACKAGER:
                return p;

            default:
                return -1;
        }
    }


}
