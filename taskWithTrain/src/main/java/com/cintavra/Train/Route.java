package com.cintavra.Train;

public class Route {
    //просто ввела дані, щоб їх можна було витягти
    private String stationNames[] = {"Київ", "Козятин", "Вінниця", "Хмельницький", "Підволочиськ", "Тернопіль", "Львів", "Ходорів", "Івано-Франківськ", " Коломия", "Чернівці"};
    private String leaveTime[] = {"10:10", "21:55"};

    //повертає усесь маршрут поїзда
    public String[] getStationNames() {
        return stationNames;
    }

    //повертає час, у який ходить поїзд
    public String[] getLeaveTime() {
        return leaveTime;
    }
}
