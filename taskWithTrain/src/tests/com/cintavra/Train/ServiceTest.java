package com.cintavra.Train;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ServiceTest {

    public Service service = new Service();

    /*@Test
    public void testSize() {

        assertEquals("Checking size of list", 6, service.trainList.size());
        System.out.println("Method testSize completed!");
    }

    @Test
    public void testTheLastElementOfTranList() {

        ArrayList<String> stations = service.trainList.get(service.trainList.size() - 1).trainListStations;
        assertEquals("Checking of the last element of trainList", Arrays.asList("k", "t", "u"), stations);
        stations.forEach(x -> System.out.print(x + " "));
    }

    @BeforeEach
    public void setParams() {
        System.out.println("HELLO");
        service.setTrainNumber(5);
        service.setCoachNumber(2);
        service.setPlaceNumber(4);
        service.setUserName("User");
        service.setStartStation("k");
        service.setEndStation("u");
    }

    @Test
    public void testSearchingOfTrainList() {

        assertEquals("Checking of searching of trains, which the user need", service.searchTrainList().size(), 2);
        System.out.println("Finish success!");
    }

    @Test
    public void testCheckingOfDataCorrect() {

        service.searchTrainList();

        assertTrue("Checking of correct data", service.dataChecking());
        System.out.println("Result: " + service.dataChecking() + "!");
    }*/
}