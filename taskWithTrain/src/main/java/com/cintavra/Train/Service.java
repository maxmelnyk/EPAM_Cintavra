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
    private ArrayList<Train> trainList = new ArrayList<>();
    private ArrayList<Train> trainsForClient = new ArrayList<>();

    public Service() {
        setTrainList();
    }

    public void setTrainList() {
        String[][] routeArray = createRoutes();
        for (int i = 0; i < routeArray.length; i++) {
            trainList.add(new Train(i + 1, routeArray[i]));
        }
    }

    public static String[][] createRoutes() {
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
            ArrayList<String> tmp = new ArrayList<>(train.trainListStations);
            if (tmp.contains(startStation.toLowerCase())
                    && tmp.contains(endStation.toLowerCase())
                    && tmp.indexOf(startStation.toLowerCase()) < tmp.indexOf(endStation.toLowerCase()))
                trainsForClient.add(train);
        }
        return trainsForClient;
    }

    public boolean dataChecking() {
        for (Train train : trainList) {
            if (trainNumber == trainList.indexOf(train) && trainsForClient.contains(train)) {
                if (coachNumber <= train.coaches.size() && train.coaches.get(coachNumber).tickets.length > placeNumber) {
                    //якщо квиток існує впринципі i вільний, то повертає true
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

    public void choosePlaceInTrain() {
        Coach foundCoach = trainList.get(trainNumber).coaches.get(coachNumber);
        buyPlace(trainList.get(trainNumber).trainListStations, foundCoach);
    }


    public void buyPlace(ArrayList<String> stations, Coach coach) {
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

    public void showFreePlace(ArrayList<String> stations, Coach coach) {
        System.out.print("\nPlace num: ");
        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {
                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {
                isPlaceStillFree(stations, coach.tickets[i], i);
            }
        }
    }

    public void isPlaceStillFree(ArrayList<String> stations, Ticket ticket, int i) {
        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {
            ticket.free = true;
            System.out.print((i + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {
            ticket.free = true;
            System.out.print((i + 1) + " ");
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
                if (dataChecking()) {
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
                        choosePlaceInTrain(); //buying ticket
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