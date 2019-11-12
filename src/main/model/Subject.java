package model;

import java.util.List;

public abstract class Subject {
    protected List<MoneyObserver> users;

    public void addUser(MoneyObserver u) {
        if (!users.contains(u)) {
            users.add(u);
        }
    }

    public void notifyUser() {
        for (MoneyObserver u : users) {
            u.update();
        }
    }
}
