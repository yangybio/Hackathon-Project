package model;

import model.exception.MoneyException;

import java.io.IOException;

public interface ReloadThings {
    public void getData(String file) throws IOException, MoneyException;
}
