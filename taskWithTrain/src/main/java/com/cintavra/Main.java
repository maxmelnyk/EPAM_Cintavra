package com.cintavra;

import com.cintavra.Train.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Train train = new Train();
        //ініціалізація поїздів
        ArrayList<Train> trains = new ArrayList<Train>();
//        for (:trains) {
            trains.add(new Train());
//        }

        //створення клієнтів


        //користувач задає пункт А і В
        //задає час
        //йому відображається список поїздів і часи їх відправлення
        //після вибору поїзда іде відображення списку вагонів із місцями
        //тоді користувач вибирає вагон і йому відображаються вількі квитки з id(місце в вагоні)
        //користувач заповнює інформацію про квиток
        //квиток виводиться користувачеві і записується в масив квитків

        Scanner scanner = new Scanner(System.in);
        String beginWay = scanner.nextLine();
        String endWay = scanner.nextLine();


//        stations = train.findBeginAndEndStations();
    }
}