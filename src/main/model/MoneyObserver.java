package model;

import java.util.Observable;
import java.util.Observer;

public class MoneyObserver implements Observer {

    //EFFECT: sout information
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
