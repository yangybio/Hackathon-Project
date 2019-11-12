package model;

public class User implements MoneyObserver {
    private ItemList usersList;

    public User(ItemList list) {
        usersList = list;
    }

    @Override
    public void update() {
        System.out.println(usersList.getTotalMoney());
    }
}
