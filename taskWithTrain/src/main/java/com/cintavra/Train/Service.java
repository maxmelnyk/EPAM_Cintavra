package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    public ArrayList<Train> trainList = new ArrayList<>();
    public ArrayList<Train> trainsForClient = new ArrayList<>();
    private int trainNumber;
    private int coachNumber;
    private int placeNumber;
    private String startStation;
    private String endStation;
    private String userName;

    public Service() {

        setTrainList();
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setCoachNumber(int coachNumber) {
        this.coachNumber = coachNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void setTrainList() {

        String[][] routeArray = createRoutes();
//        String[] timeArray = {"2018-04-01T03:30", "2018-04-01T03:30", "2018-04-01T03:30"};

        for (int i = 0; i < routeArray.length; i++) {

            trainList.add(new Train(i + 1, /*LocalDateTime.parse(timeArray[i]),*/ routeArray[i]));
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

    public ArrayList<Train> searchTrainList() {
        for (Train train : trainList) {

            if (train.trainListStations.contains(startStation.toLowerCase()) && train.trainListStations.contains(endStation.toLowerCase()) &&
                    train.trainListStations.indexOf(startStation.toLowerCase()) < train.trainListStations.indexOf(endStation.toLowerCase()))
                trainsForClient.add(train);
        }

        return trainsForClient;
    }

    public boolean dataChecking() {

        if (trainsForClient.size() > trainNumber)
            if (trainsForClient.get(trainNumber).coaches.size() > coachNumber)
                if (trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets.length > placeNumber)

                    //якщо квиток вільний і існує впринципі, то повертає true
                    return trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free;

        return false;
    }

    private void removetrainsForClient() {

        trainsForClient.clear();
    }

    private void showAllPlaceInTrain() {

        for (Train train : trainsForClient) {

            int printDataAboutTrain = 0;

            for (Coach coach : train.coaches) {
                if (coach.getCountFreePlace() != 0) {
                    if (printDataAboutTrain == 0) {
                        System.out.print("Train number: " + train.getTrainId()/* + " (DateTime: " + date + ")"*/);
                        printDataAboutTrain++;
                    }
                    System.out.print("\nCoach number: " + (train.coaches.indexOf(coach) + 1));
                    showFreePlace(train.trainListStations, coach);
                }
            }

            if (printDataAboutTrain == 1) {
                System.out.println();
                System.out.println();
            }
        }
    }

    public void buyPlace() {
        Train train = trainList.get(trainNumber);

        if (!train.coaches.get(coachNumber).tickets[placeNumber].free) {
            if (train.trainListStations.indexOf(startStation) < train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].startStation) && train.trainListStations.indexOf(endStation) <= train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].startStation)) {

                train.coaches.get(coachNumber).tickets[placeNumber].startStation = startStation;
            } else if (train.trainListStations.indexOf(startStation) >= train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].endStation) && train.trainListStations.indexOf(endStation) > train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].endStation)) {

                train.coaches.get(coachNumber).tickets[placeNumber].endStation = endStation;
            }
        }

        train.coaches.get(coachNumber).tickets[placeNumber].buyTicket(startStation, endStation, userName);
        train.coaches.get(coachNumber).countFreePlace--;
    }

    private void showFreePlace(ArrayList<String> stations, Coach coach) {

        System.out.print("\nPlace num: ");

        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {

                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {

                isFree(stations, coach.tickets[i], i);
            }
        }
    }

    private void isFree(ArrayList<String> stations, Ticket ticket, int i) {

        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {

            ticket.free = true;
            System.out.print((i + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {

            ticket.free = true;
            System.out.print((i + 1) + " ");
        }
    }

    private void checkTicketState() {
        Ticket ticket = trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber];

        if (!ticket.startStation.isEmpty()) {
            ticket.free = false;
        }
    }

    public void ticketOrder() {

        Scanner scan = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Enter start station:");
            startStation = scan.nextLine();

            System.out.println("Enter final station:");
            endStation = scan.nextLine();

            if (searchTrainList().isEmpty()) {

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

                        buyPlace(); //buying ticket
                        removetrainsForClient();
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