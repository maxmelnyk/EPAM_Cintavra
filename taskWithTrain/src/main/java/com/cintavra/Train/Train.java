package com.cintavra.Train;

import java.util.ArrayList;

public class Train {
    private static final int COUNT_OF_COACHES = 3;
    private int trainId;
    private Station station;
    private Route route;
    private Coach coaches[];
    private ArrayList<String> ourRout;

    //перевіряємо чи поїзд їде по потрібних нам станціях
    private boolean checkStation() {
        boolean result = false;
        for (String stationName : route.getListOfStation()) {
            if (stationName.contains(station.getBeginStation())) {
                if (stationName.contains(station.getEndStation())) {
                    result = true;
                }
            }
        }
        return result;
    }

    //перевіряємо час
    public String[] checkTime() {
        return route.getTime();
    }


    //показуємо наш маршрут
    public void createOurRoute() {
        if (checkStation()) {
            for (String stationName : route.getListOfStation()) {
                if (stationName.indexOf(0) <= stationName.indexOf(station.getBeginStation())
                        && stationName.indexOf(route.getListOfStation().length - 1) >= stationName.indexOf(station.getEndStation())) {
                    ourRout.add(stationName);
                }
            }
        }
        System.out.println(ourRout);
    }
//TODO не знаю, що тут потрібно було писати
    /*public Station viewStation(Station wellStations[]){

    }*/

    public Coach[] getCoaches() {
        coaches = new Coach[COUNT_OF_COACHES];
        for (int i = 0; i < COUNT_OF_COACHES; i++) {
            coaches[i] = new Coach();
        }

        return coaches;
    }
}