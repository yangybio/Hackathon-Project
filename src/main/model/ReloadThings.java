package model;

import model.exception.MoneyException;

import java.io.IOException;

public interface ReloadThings {

    //MODIFIES:file
    //EFFECT: retrieve data from file
    public void getData(String file) throws IOException, MoneyException;
}
