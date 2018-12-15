package com.cintavra.Train;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Train {
    private int countOfCoaches;
    private int trainId;
//    public LocalDateTime date;
    protected ArrayList<Coach> coaches = new ArrayList<>();
    protected ArrayList<String> trainListtations = new ArrayList<>();

    Train(int trainId, /*LocalDateTime date,*/ String[] route) {
        this.countOfCoaches = 3;
        this.trainId = trainId;
        setCoaches();
//        this.date = date;
        this.trainListtations.addAll(Arrays.asList(route));

    }

    private void setCoaches(){

        for (int i = 0; i < countOfCoaches; i++) {
            Coach coach = new Coach();  //ініціалізація даних про вагон
            coaches.add(coach);
        }
    }

    protected int getTrainId() {
        return trainId;
    }
}
