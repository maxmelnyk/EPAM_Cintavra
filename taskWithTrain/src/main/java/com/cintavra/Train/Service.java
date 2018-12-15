package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private ArrayList<Train> trains = new ArrayList<>();
    public ArrayList<Train> trainSearcher = new ArrayList<>();
    private int trainNumber;
    private int coachNumber;
    private int placeNumber;
    private String startStation;
    private String endStation;
    private String userName;

    public Service() {

        setTrains();
    }

    private void setTrains() {

        String[][] routeArray = createRoutes();
//        String[] timeArray = {"2018-04-01T03:30", "2018-04-01T03:30", "2018-04-01T03:30"};

        for (int i = 0; i < routeArray.length; i++) {

            trains.add(new Train(i + 1, /*LocalDateTime.parse(timeArray[i]),*/ routeArray[i]));
        }
    }

    private static String[][] createRoutes() {

        return new String[][]{
                {"l", "t", "k"},
                {"u", "l", "k"},
                {"u", "t", "k"},
                {"k", "t", "l"},
                {"k", "l", "u"},
                {"k", "t", "u"}
        };
    }

    public ArrayList<Train> searchTrains() {
        for (Train lookThroughTrains : trains) {
            ArrayList<String> tmp = new ArrayList<>(lookThroughTrains.trainStations);
            if (tmp.contains(startStation.toLowerCase()) && tmp.contains(endStation.toLowerCase()) &&
                    tmp.indexOf(startStation.toLowerCase()) < tmp.indexOf(endStation.toLowerCase()))
                trainSearcher.add(lookThroughTrains);
        }

        return trainSearcher;
    }

    public boolean dataChecking() {

        if (trainSearcher.size() > trainNumber)
            if (trainSearcher.get(trainNumber).coaches.size() > coachNumber)
                if (trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets.length > placeNumber)

                    //якщо квиток вільний і існує впринципі, то повертає true
                    return trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free; /*true*/ //Якщо поставити true, то враховуватиме можливість замовлення зайнятого квитка, але завжди виводитиме усі квитки.

        return false;
    }

    public void removeTrainSearcher() {

        trainSearcher.clear();
    }

    public void showAllPlaceInTrain() {

        for (Train train : trainSearcher) {

            int printDataAboutTrain = 0;

            for (Coach coach : train.coaches) {
                if (coach.getCountFreePlace() != 0) {
                    if (printDataAboutTrain == 0) {
                        System.out.print("Train number: " + train.getTrainId()/* + " (DateTime: " + date + ")"*/);
                        printDataAboutTrain++;
                    }
                    System.out.print("\nCoach number: " + (train.coaches.indexOf(coach) + 1));
                    showFreePlace(startStation, endStation, train.trainStations, coach);
                }
            }

            if (printDataAboutTrain == 1) {
                System.out.println();
                System.out.println();
            }
        }
    }

    public void choosePlaceInTrain() {

        Coach foundCoach = trainSearcher.get(trainNumber).coaches.get(coachNumber);
        buyPlace(placeNumber, startStation, endStation, trainSearcher.get(trainNumber).trainStations, userName, foundCoach);
    }

    public void buyPlace(int placeNumber, String startStation, String endStation, ArrayList<String> stations, String userName, Coach coach) {

        if (!coach.tickets[placeNumber].free) {
            if (stations.indexOf(startStation) < stations.indexOf(coach.tickets[placeNumber].startStation) && stations.indexOf(endStation) <= stations.indexOf(coach.tickets[placeNumber].startStation)) {

                coach.tickets[placeNumber].startStation = startStation;
            } else if (stations.indexOf(startStation) >= stations.indexOf(coach.tickets[placeNumber].endStation) && stations.indexOf(endStation) > stations.indexOf(coach.tickets[placeNumber].endStation)) {

                coach.tickets[placeNumber].endStation = endStation;
            }
        }

        coach.tickets[placeNumber].buyTicket(startStation, endStation, userName);
        coach.countFreePlace--;
    }

    public void showFreePlace(String startStation, String endStation, ArrayList<String> stations, Coach coach) {

        System.out.print("\nPlace num: ");

        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {

                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {

                isFree(startStation, endStation, stations, coach.tickets[i], i);
            }
        }
    }

    private void isFree(String startStation, String endStation, ArrayList<String> stations, Ticket ticket, int i) {

        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {

            ticket.free = true;
            System.out.print((i + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {

            ticket.free = true;
            System.out.print((i + 1) + " ");
        }
    }

    public void checkTicketState() {
        Ticket ticket = trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber];
        if (!ticket.startStation.isEmpty()) {
            ticket.free = false;
        }
    }

    public void ticketOrder() {

        Scanner scan = new Scanner(System.in);
        int choice = 0;

        do {

            System.out.println("Enter start station:");
            startStation = scan.nextLine();

            System.out.println("Enter final station:");
            endStation = scan.nextLine();

            if (searchTrains().isEmpty()) {

                System.out.println("There is no train with such route.");
            } else {

                showAllPlaceInTrain();

                System.out.println("Enter number of train:");
                trainNumber = scan.nextInt() - 1;

                System.out.println("Enter number of coach:");
                coachNumber = scan.nextInt() - 1;

                System.out.println("Enter number of place:");
                placeNumber = scan.nextInt() - 1;

                //перевірка на існування даних за значеннями введених користувачем
                if (dataChecking()) {

                    System.out.println();
                    System.out.println("Print your name:");
                    scan.nextLine();
                    userName = scan.nextLine();
                    System.out.println();

                    System.out.println("Ticket info:");
                    System.out.println(" Train number: " + (trainNumber + 1) + "\n Number of coach: " + (coachNumber + 1) +
                            "\n Place number: " + (placeNumber + 1) + "\n Customer: " + userName);
                    System.out.println("\nTo proceed enter 1");

                    choice = scan.nextInt();

                    if (choice == 1) {

                        //buying ticket
                        choosePlaceInTrain();
                        removeTrainSearcher();
                        System.out.println("Purchase successful!");
                    } else {
                        checkTicketState();
                    }

                } else {

                    System.out.println("Incorrect data!\nTry again.");
                }
            }

            System.out.println("\nTo buy another ticket enter 1");
            choice = scan.nextInt();
            scan.nextLine();

        } while (choice == 1);
    }
}