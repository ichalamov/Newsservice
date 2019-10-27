package news;

import java.util.ArrayList;
import java.util.Date;
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

        users.add(new User(1, "Richard","McInnis","RichardSMcInnis@dayrep.com",
                rolesMockedData.getRoleByName("READER")));
        users.add(new User(2, "Kevin","Parker" ,"kevin.parker@yahoo.com",
                rolesMockedData.getRoleByName("ADMIN")));
        users.add(new User(3, "Judy","Wiles" ,"JudyDWiles@yahoo.com",
                rolesMockedData.getRoleByName("PUBLISHER")));
        users.add(new User(4, "Alice","Hernandez" ,"AliceTHernandez@rhyta.com",
                rolesMockedData.getRoleByName("READER")));


    }

}
