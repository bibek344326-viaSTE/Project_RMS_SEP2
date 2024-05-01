package client.model.kitchen;

import client.mediator.kitchen.KitchenClient;
import client.mediator.login.LoginClient;

public class KitchenModelManager implements KitchenModel {

    private final KitchenClient kitchenClient;

    public KitchenModelManager(KitchenClient client) {
        this.kitchenClient = client;
    }

    @Override
    public void loginToKitchenView(String hi) {
        kitchenClient.loginToKitchenView(hi);
    }
}
