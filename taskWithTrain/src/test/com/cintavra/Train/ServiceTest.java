package com.cintavra.Train;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTest {
    public Service service = new Service();



    Train train = new Train(0, service.createRoutes(0));

    @Test
    public void testCountOfRoutes() {
        assertEquals("Checking amount of trains", 3, service.createTrainList().size());
    }

    @Test
    public void testIfTrainExist() {
        assertNotEquals(train.getTrainId(), 5);
    }

    @Test
    public void testIfCount0fCouches() {
        assertEquals("Checking amount of couches in the train", 0, train.getCoaches().size());
    }
}