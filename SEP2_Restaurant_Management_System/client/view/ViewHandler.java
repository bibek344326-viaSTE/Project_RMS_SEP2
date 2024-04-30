package client.view;

import client.core.ViewModelFactory;
import client.view.table.TableViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private final ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene loginScene;
    private Scene customerScene;
    private Scene staffScene;
    private Scene kitchenScene;
    private Scene tableScene;


    private TableViewController tableViewController;


    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        stage = new Stage();
        openLogin();

    }

    private void openLogin() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("./login/RestaurantLoginView.fxml");
                loginScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        stage.setTitle("Login");
        stage.setScene(loginScene);
        stage.show();
    }


    public void openCustomerView() {
        if (customerScene == null) {
            try {
                Parent root = loadFXML("./login/CustomerTableNumberView.fxml");
                customerScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stage.setTitle("Login To Customer View");
        stage.setScene(customerScene);
        stage.show();


    }

    public void openStaffView() {
        if (staffScene == null) {
            try {
                Parent root = loadFXML("./login/StaffMemberLogin.fxml");
                staffScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        stage.setTitle("Login To Staff Member View");
        stage.setScene(staffScene);
        stage.show();
    }


    public void openKitchenStaffView() {
        if (kitchenScene == null) {
            try {
                Parent root = loadFXML("./login/KitchenStaffLogin.fxml");
                kitchenScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        stage.setTitle("Login To kitchen staff View");
        stage.setScene(kitchenScene);
        stage.show();
    }
    public void openTableView() {
        if (tableScene == null) {
            try {
                Parent root = loadFXML("./table/Table.fxml");
                tableScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        stage.setTitle("Table View");
        stage.setScene(tableScene);
        stage.show();
    }



    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController controller = loader.getController();
        controller.init(viewModelFactory, this);
        return root;
    }
}