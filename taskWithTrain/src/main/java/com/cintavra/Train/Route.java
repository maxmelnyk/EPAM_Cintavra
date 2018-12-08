package com.cintavra.Train;

public class Route {
    //просто ввела дані, щоб їх можна було витягти
    private String stationNames[] = {"Київ", "Козятин", "Вінниця", "Хмельницький", "Підволочиськ", "Тернопіль", "Львів", "Ходорів", "Івано-Франківськ", " Коломия", "Чернівці"};
    private String leaveTimes[] = {"10:10", "15:40", "21:55"};

    //повертає усесь маршрут поїзда
    public String[] getListOfStation() {
        return stationNames;
    }

    //повертає час уякий ходить поїзд
    public String[] getTime() {
        return leaveTimes;
    }

}
