package sharedResources.utils.user;

import java.io.Serializable;

public class StaffMember extends User implements Serializable {
    private String userType;

    public StaffMember(String userName, String password) {
        super(userName, password);
        this.userType = Usertype.STAFFMEMBER.toString();
    }

    @Override
    public String getUserType() {
        return userType;
    }

}
