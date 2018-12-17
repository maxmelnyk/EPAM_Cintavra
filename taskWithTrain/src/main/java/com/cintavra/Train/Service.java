package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private int trainNumber;
    private int coachNumber;
    private int placeNumber;
    private String startStation;
    private String endStation;
    private String userName;

    public ArrayList<Train> trainList = new ArrayList<>();
    public ArrayList<Train> trainsForClient = new ArrayList<>();

    public Service() {
        createTrainList();
    }

    public ArrayList<Train> getTrainList() {
        return trainList;
    }

    public void createTrainList() {
        String[][] routeArray = createRoutes();
        for (int i = 0; i < routeArray.length; i++) {
            trainList.add(new Train(i + 1, routeArray[i]));
        }
    }

    public String[][] createRoutes() {
        return new String[][]{
                {"lviv", "ternopil", "kyiv"},
                {"uzhgorod", "lviv", "kyiv"},
                {"uzhgorod", "ternopil", "kyiv"},
                {"kyiv", "ternopil", "lviv"},
                {"kyiv", "lviv", "uzhgorod"},
                {"kyiv", "ternopil", "uzhgorod"},
                {"kyiv", "ternopil", "zhytomyr", "uzhgorod"},
                {"uzhgorod", "zhytomyr", "ternopil", "kyiv"}
        };
    }

    public ArrayList<Train> searchAppropriateTrain() {
        for (Train train : trainList) {
            if (train.trainListStations.contains(startStation.toLowerCase())
                    && train.trainListStations.contains(endStation.toLowerCase())
                    && train.trainListStations.indexOf(startStation.toLowerCase()) < train.trainListStations.indexOf(endStation.toLowerCase())) {
                trainsForClient.add(train);
            }
        }
        return trainsForClient;
    }

    public boolean checkEnteredData() {
        for (Train train : trainList) {
            if (trainNumber == trainList.indexOf(train) && trainsForClient.contains(train)) {
                if (coachNumber <= train.coaches.size() && train.coaches.get(coachNumber).tickets.length > placeNumber) {
                    return trainList.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free;
                }
            }
        }
        return false;
    }

    public void removeTrainsForClient() {
        trainsForClient.clear();
    }

    public void showAllPlaceInTrain() {
        for (Train train : trainsForClient) {
            int printDataAboutTrain = 0;
            for (Coach coach : train.coaches) {
                if (coach.getCountFreePlace() != 0) {
                    if (printDataAboutTrain == 0) {
                        System.out.print("Train number: " + train.getTrainId());
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

    public void showFreePlace(ArrayList<String> stations, Coach coach) {
        System.out.print("\nPlace num: ");
        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {
                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {
                isPlaceStillFree(stations, coach.tickets[i]);
            }
        }
    }

    public void isPlaceStillFree(ArrayList<String> stations, Ticket ticket) {
        int count = 0;
        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {
            ticket.free = true;
            System.out.print((count + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {
            ticket.free = true;
            System.out.print((count + 1) + " ");
        }
    }

    public void checkTicketState() {
        Ticket ticket = trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber];
        if (!ticket.startStation.isEmpty()) {
            ticket.free = false;
        }
    }

    public void orderTicket() {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter start station:");
            startStation = scan.nextLine();

            System.out.println("Enter final station:");
            endStation = scan.nextLine();

            if (searchAppropriateTrain().isEmpty()) {
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
                if (checkEnteredData()) {
                    System.out.println();
                    System.out.println("Print your name:");
                    scan.nextLine();
                    userName = scan.nextLine();
                    System.out.println();

                    System.out.println("Ticket info:");
                    System.out.println(" Train number: " + (trainNumber + 1) + "\n Number of coach: " + (coachNumber + 1) +
                            "\n Place number: " + (placeNumber + 1) + "\n Customer: " + userName);
                    System.out.println("\nTo confirm your order enter 1");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        buyPlace();
                        removeTrainsForClient();
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