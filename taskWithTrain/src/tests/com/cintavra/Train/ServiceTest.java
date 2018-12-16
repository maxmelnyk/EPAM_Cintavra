package com.cintavra.Train;

//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

class ServiceTest {
    public Service service = new Service();


    @Test
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

    @Before
    public void setParams(){
    }

    @Test
    public void testSearchingOfTrainList(){
        service.setStartStation("k");
        service.setEndStation("u");

        assertEquals("Checking of searching of trains, which the user need", service.searchTrainList().size(), 2);
        System.out.println("Finish success!");
    }

    @Test
    public void testCheckingOfDataCorrect(){
        service.setTrainNumber(5);
        service.setCoachNumber(2);
        service.setPlaceNumber(4);
        service.setUserName("User");
        service.setStartStation("k");
        service.setEndStation("u");
        service.searchTrainList();

        assertTrue("Checking of correct data", service.dataChecking());
        System.out.println("Result: " + service.dataChecking() + "!");
    }

    @Test
    public void ticketOrder() {

    }
}