package news;

import java.util.ArrayList;
import java.util.List;

public class PrivilegesMockedData {

    //list of privileges
    private List<Privilege> privileges;

    private static PrivilegesMockedData instance = null;

    public static PrivilegesMockedData getInstance() {
        if (instance == null) {
            instance = new PrivilegesMockedData();
        }
        return instance;
    }


    public PrivilegesMockedData() {
        privileges = new ArrayList<Privilege>();
        privileges.add(new Privilege(1, "READ"));
        privileges.add(new Privilege(2, "EDIT_OWN_CONTENT"));
        privileges.add(new Privilege(3, "EDIT_ALL_CONTENT"));
        privileges.add(new Privilege(4, "DELETE_OWN_CONTENT"));
        privileges.add(new Privilege(5, "DELETE_ALL_CONTENT"));
        privileges.add(new Privilege(6, "CREATE_CONTENT"));


    }

    // return privilege by name
    public Privilege getPrivilegeByName(String name) {
        for (Privilege p : privileges) {
            if (p.getName() == name) {
                return p;
            }
        }
        return null;
    }

}
