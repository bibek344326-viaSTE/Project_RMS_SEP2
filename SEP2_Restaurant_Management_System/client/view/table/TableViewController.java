package client.view.table;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import sharedResources.utils.table.Table;

public class TableViewController implements ViewController {
    @FXML
    private TableView<Table> tableView;
    @FXML
    private TableColumn<Table, Integer> tableNumberColumn;
    @FXML
    private TableColumn<Table, Boolean> capacityColumn;
    @FXML
    private TableColumn<Table, Boolean> statusColumn;
    @FXML
    private TableColumn<Table, String> reservedByColumn;
    @FXML
    private Button clearSelectedTableButton;
    @FXML
    private Button addNewTableButton;
    @FXML
    private Button editTableDetailsButton;
    @FXML
    private Button deleteTableButton;
    private ViewHandler viewHandler;
    private TableViewModel tableViewModel;
    private Region root;


    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.tableViewModel = viewModelFactory.getTableViewModel();
    }
        /*tableView.setItems(tableViewModel.getTableList());
        tableNumberColumn.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("isOccupied"));
        reservedByColumn.setCellValueFactory(new PropertyValueFactory<>("tableName"));*/

    @FXML
    private void clearSelectedTableButton() {
        tableView.getSelectionModel().clearSelection();
    }

    @FXML
    private void addNewTableButton() {
        tableViewModel.addNewTable();
    }

    @FXML
    private void deleteTableButton() {
        Table selectedTable = tableView.getSelectionModel().getSelectedItem();
        if (selectedTable != null) {
            tableViewModel.deleteTable();
        }
    }

    public void updateTableDetailsButton(ActionEvent actionEvent) {
        Table selectedTable = tableView.getSelectionModel().getSelectedItem();
        if (selectedTable != null) {
            tableViewModel.updateTableDetails();
        }
    }


}
