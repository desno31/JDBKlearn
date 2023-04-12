package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Oleg", "OLEGG", (byte) 2);
        user.saveUser("Olga", "QWE", (byte) 22);
        user.saveUser("Olgert", "OLEDDDDD", (byte) 13);
        user.saveUser("Olekper", "ASDZ", (byte) 16);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
