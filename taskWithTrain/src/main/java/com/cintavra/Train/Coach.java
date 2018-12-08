package com.cintavra.Train;

import java.util.ArrayList;

public class Coach {
    final private static int AMOUNT_OF_PLACES = 4;
    boolean place[] = new boolean[AMOUNT_OF_PLACES];

    public Coach(){
        for(int value = 0; value < AMOUNT_OF_PLACES; value ++)
            place[value] = true;
    }

    public void buyPlace(int numberPlace){
        place[numberPlace] = false;
    }

    public void showFreePlace(){
        for(int i = 0; i < AMOUNT_OF_PLACES; i++){
            if(place[i]==true)
                System.out.print(i + 1 + " ");
        }
    }
}
