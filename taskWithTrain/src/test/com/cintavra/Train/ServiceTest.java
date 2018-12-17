package com.cintavra.Train;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class ServiceTest {
    public Service service = new Service();
    public Train train = new Train(7, new String[]{"kyiv", "ternopil", "zhytomyr", "uzhgorod"});

    @Test
    public void testCountOfRoutes() {
        assertEquals("Checking count of route", 8, service.trainList.size());
    }

    @Test
    public void testIfTrainExist() {
        assertEquals(train.getTrainId(), 7);
    }

    @Test
    public void findElementOfTranList() {
        for (Train train : service.getTrainList()) {
            if (train.getTrainId() == 7) {
                assertEquals(train.getTrainListStations(), Arrays.asList("kyiv", "ternopil", "zhytomyr", "uzhgorod"));
                System.out.println("+");
            }
        }
    }
}