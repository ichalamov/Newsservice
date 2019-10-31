package data;

import news.User;

import java.util.ArrayList;
import java.util.List;

public class UsersMockedData {

    //list of users
    private List<User> users;

    private static UsersMockedData instance = null;

    public static UsersMockedData getInstance() {
        if (instance == null) {
            instance = new UsersMockedData();
        }
        return instance;
    }


    public UsersMockedData() {
        users = new ArrayList<User>();
        RolesMockedData rolesMockedData = RolesMockedData.getInstance();

        users.add(new User(1, "richmc","Richard","McInnis","RichardSMcInnis@dayrep.com",
                rolesMockedData.getRoleByName("READER")));
        users.add(new User(2, "kev_admin","Kevin","Parker" ,"kevin.parker@yahoo.com",
                rolesMockedData.getRoleByName("ADMIN")));
        users.add(new User(3, "judy_pub", "Judy","Wiles" ,"JudyDWiles@yahoo.com",
                rolesMockedData.getRoleByName("PUBLISHER")));
        users.add(new User(4,"alice_reader", "Alice","Hernandez" ,"AliceTHernandez@rhyta.com",
                rolesMockedData.getRoleByName("READER")));


    }

    // return user by username
    public User getUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername() == username) {
                return u;
            }
        }
        return null;
    }

}
