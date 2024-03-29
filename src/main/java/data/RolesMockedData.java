package data;

import news.News;
import news.Privilege;
import news.Role;

import java.util.ArrayList;
import java.util.List;

public class RolesMockedData {

    //list of roles
    private List<Role> roles;
    private List<Privilege> adminPrivileges;
    private List<Privilege> readerPrivileges;
    private List<Privilege> publisherPrivileges;


    private static RolesMockedData instance = null;

    public static RolesMockedData getInstance() {
        if (instance == null) {
            instance = new RolesMockedData();
        }
        return instance;
    }


    public RolesMockedData() {
        roles = new ArrayList<Role>();
        adminPrivileges = new ArrayList<Privilege>();
        readerPrivileges = new ArrayList<Privilege>();
        publisherPrivileges = new ArrayList<Privilege>();
        PrivilegesMockedData privilegesMockedData = PrivilegesMockedData.getInstance();

        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("READ"));
        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("EDIT_OWN_CONTENT"));
        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("EDIT_ALL_CONTENT"));
        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("DELETE_OWN_CONTENT"));
        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("DELETE_ALL_CONTENT"));
        adminPrivileges.add(privilegesMockedData.getPrivilegeByName("CREATE_CONTENT"));

        readerPrivileges.add(privilegesMockedData.getPrivilegeByName("READ"));

        publisherPrivileges.add(privilegesMockedData.getPrivilegeByName("READ"));
        publisherPrivileges.add(privilegesMockedData.getPrivilegeByName("CREATE"));
        publisherPrivileges.add(privilegesMockedData.getPrivilegeByName("EDIT_OWN_CONTENT"));
        publisherPrivileges.add(privilegesMockedData.getPrivilegeByName("DELETE_OWN_CONTENT"));

        roles.add(new Role(1, "ADMIN", adminPrivileges));
        roles.add(new Role(2, "READER", readerPrivileges));
        roles.add(new Role(3, "PUBLISHER", publisherPrivileges));

    }

    // return role by name
    public Role getRoleByName(String name) {
        for (Role r : roles) {
            if (r.getName() == name) {
                return r;
            }
        }
        return null;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Privilege> getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(List<Privilege> adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

    public List<Privilege> getReaderPrivileges() {
        return readerPrivileges;
    }

    public void setReaderPrivileges(List<Privilege> readerPrivileges) {
        this.readerPrivileges = readerPrivileges;
    }

    public List<Privilege> getPublisherPrivileges() {
        return publisherPrivileges;
    }

    public void setPublisherPrivileges(List<Privilege> publisherPrivileges) {
        this.publisherPrivileges = publisherPrivileges;
    }

    // delete role by id
    public String delete(int id) {
        int roleIndex = -1;
        for (Role r : roles) {
            if (r.getId() == id) {
                roleIndex = roles.indexOf(r);
                continue;
            }
        }
        if (roleIndex > -1) {
            roles.remove(roleIndex);
        }
        return "Role deleted succesfully.";
    }
}
