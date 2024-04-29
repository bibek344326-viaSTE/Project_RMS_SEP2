package client.view;

import client.core.ViewModelFactory;
import client.view.table.TableViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private final ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene loginScene;
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
                Parent root = loadFXML("./login/LoginView.fxml");
                loginScene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        stage.setTitle("Login");
        stage.setScene(loginScene);
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
        stage.setTitle("tableView");
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