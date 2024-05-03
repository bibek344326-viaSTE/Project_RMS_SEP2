package client.view.staff;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import client.model.staff.StaffModel;

public class StaffViewModel {

    private final StaffModel staffModel;

    public StaffViewModel(ModelFactory modelFactory) {
        this.staffModel = modelFactory.getStaffModel();
        // bind textarea over here
    }

    public void loginToStaffMemberView(String tableView) {
        // change name of argument better option is to create User and send Request obj
        staffModel.loginToStaffMemberView(tableView);
    }
}
