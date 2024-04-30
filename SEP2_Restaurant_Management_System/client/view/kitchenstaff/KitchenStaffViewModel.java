package client.view.kitchenstaff;

import client.core.ModelFactory;
import client.model.Reservation.ReservationModel;
import client.model.kitchen.KitchenModel;

public class KitchenStaffViewModel {

    private final KitchenModel kitchenModel;

    public KitchenStaffViewModel(ModelFactory modelFactory) {
        this.kitchenModel = modelFactory.getKitchenModel();
        // bind textarea over here
    }

    public void loginToKitchenView(String tableView) {
        // change name of argument better option is to create User and send Request obj
        kitchenModel.loginToKitchenView(tableView);
    }
}
