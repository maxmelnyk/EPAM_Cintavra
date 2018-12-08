package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Railway {
    public ArrayList<Train> trains = new ArrayList<Train>();
    public ArrayList<Train> trainSeacher = new ArrayList<Train>();

    public Railway(){
        Train train1 = new Train();
        trains.add(train1);
        train1.setTrainId(1);
        train1.setTrainStations("Lviv", "Ternopil", "Kyiv");

        Train train2 = new Train();
        trains.add(train2);
        train2.setTrainId(2);
        train2.setTrainStations("Ughorod", "Lviv", "Kyiv");

        Train train3 = new Train();
        trains.add(train3);
        train3.setTrainId(3);
        train3.setTrainStations("Ughorod", "Ternopil", "Kyiv");
    }


    public ArrayList<Train> searchTrains(String station1, String station2){
        for(Train lookThroughTrains : trains){
            if(lookThroughTrains.trainStations.contains(station1) && lookThroughTrains.trainStations.contains(station2) &&
            lookThroughTrains.trainStations.indexOf(station1)<lookThroughTrains.trainStations.indexOf(station2))
                trainSeacher.add(lookThroughTrains);
        }
        return trainSeacher;
    }

    public void removeTrainSeacher(){
            trainSeacher.clear();
    }
}
