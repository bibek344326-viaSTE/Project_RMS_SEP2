package client.core;

import client.model.Reservation.ReservationModel;
import client.model.table.TableModel;
import client.view.login.LoginViewModel;
import client.view.table.TableViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private TableViewModel tableViewModel;
    private TableModel model;
    private ReservationModel reservationmodel;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLogInViewModel() {
        if (loginViewModel == null){
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }
    public TableViewModel getTableViewModel() {
        if (tableViewModel  == null){
            tableViewModel = new TableViewModel(model,reservationmodel);
        }
        return tableViewModel;
    }
    }


