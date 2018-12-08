package com.cintavra.Train;

import java.util.ArrayList;

public class Train {
    final private static int COUNT_OF_COACHS=3;
    public int trainId;
    ArrayList<Coach> coaches = new ArrayList<Coach>();
    ArrayList<String> trainStations = new ArrayList<String>();

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public void setTrainStations(String ...a){
        for(String str : a)
            trainStations.add(str);
    }

    Train(){
        for(int i = 0; i < COUNT_OF_COACHS; i++) {
            Coach coach = new Coach();  //ініціалізація даних про вагон
            coaches.add(coach);
        }
    }

    public void allPlaceInTrain(){
        for(Coach value : coaches){
            value.showFreePlace();
            System.out.println();
        }
    }

    public void choosePlaceInTrain(int numberCoach, int numberPlace){
        Coach foundCoach = coaches.get(numberCoach);
        foundCoach.buyPlace(numberPlace);
    }
}
