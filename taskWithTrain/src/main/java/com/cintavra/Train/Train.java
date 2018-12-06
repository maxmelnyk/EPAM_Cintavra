package com.cintavra.Train;

import java.util.ArrayList;

public class Train {
    final private static int COUNT_OF_COACHS = 3;
    private int trainId;
    private ArrayList<Station> stations;
    private String beginStation;
    private String endStation;
    private Coach coaches[];

/*    public Train(String beginStation, String endStation) {

        this.beginStation = beginStation;
        this.endStation = endStation;
    }*/

    public Train(int trainId) {

        this.trainId = trainId;
    }

/*    public Station[] findBeginAndEndStations() {
        Station wellStations[] ;

        viewStation(wellStations);
        return null nwellStations;
    }*/

    public void setTrainId(int trainId) {

        this.trainId = trainId;
    }

    public void createStations() {

        ArrayList<Station> stations = new ArrayList<Station>();
        /*
        * цикл по кількості станцій
        * ініціалізація станції
        * запис станції в колекцію*/
        Station station = new Station();


        this.stations = stations;
    }

    public void setCoachs() {
        Coach coaches[] = new Coach[COUNT_OF_COACHS];

        for(int i = 0; i < COUNT_OF_COACHS; i++){
            Coach coach = new Coach();  //ініціалізація даних про вагон
            //додаємо в масив вагонів
        }

        this.coaches = coaches;
    }

    /*public Station viewStation(Station wellStations[]){


    }*/
}
