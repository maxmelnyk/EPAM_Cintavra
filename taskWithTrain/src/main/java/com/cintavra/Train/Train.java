package com.cintavra.Train;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Train {
    final private static int COUNT_OF_COACHES = 1;
    private int trainId;
//    public LocalDateTime date;
    public ArrayList<Coach> coaches = new ArrayList<>();
    public ArrayList<String> trainStations = new ArrayList<>();

    Train(int trainId, /*LocalDateTime date,*/ String[] route) {
        for (int i = 0; i < COUNT_OF_COACHES; i++) {
            Coach coach = new Coach();  //ініціалізація даних про вагон
            coaches.add(coach);
        }
        this.trainId = trainId;
//        this.date = date;
        this.trainStations.addAll(Arrays.asList(route));

    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
}
