package com.thoughtworks.service;

import com.thoughtworks.service.enums.ChemicalType;
import com.thoughtworks.service.models.Chemical;
import com.thoughtworks.service.service.ChemicalFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mallikarjuna on 6/1/16.
 */
public class ChemiacalFactoryTest {

    @Test
    public void testChemXX()  {
        Chemical chemicalX1=new Chemical(ChemicalType.CHEMICALX);
        Chemical chemicalX2=new Chemical(ChemicalType.CHEMICALX);

        int hours = new ChemicalFactory().process(chemicalX1,chemicalX2);

        Assert.assertThat(hours, is(13));
    }


    @Test
    public void testChemXY()  {
        Chemical chemicalX=new Chemical(ChemicalType.CHEMICALX);
        Chemical chemicalY=new Chemical(ChemicalType.CHEMICALY);

        int hours = new ChemicalFactory().process(chemicalX,chemicalY);

        Assert.assertThat(hours, is(12));
    }

    @Test
    public void testChemXXZ(){
        Chemical chemicalX1=new Chemical(ChemicalType.CHEMICALX);
        Chemical chemicalX2=new Chemical(ChemicalType.CHEMICALX);
        Chemical chemicalZ=new Chemical(ChemicalType.CHEMICALZ);

        int hours = new ChemicalFactory().process(chemicalX1,chemicalX2,chemicalZ);

        Assert.assertThat(hours, is(17));
    }


    @Test
    public void testChemYYYXZ(){
        Chemical chemicalY1=new Chemical(ChemicalType.CHEMICALY);
        Chemical chemicalY2=new Chemical(ChemicalType.CHEMICALY);
        Chemical chemicalY3=new Chemical(ChemicalType.CHEMICALY);
        Chemical chemicalX=new Chemical(ChemicalType.CHEMICALX);
        Chemical chemicalZ=new Chemical(ChemicalType.CHEMICALZ);

        int hours = new ChemicalFactory().process(chemicalY1,chemicalY2,chemicalY3, chemicalX,chemicalZ);

        Assert.assertThat(hours, is(17));
    }

}
