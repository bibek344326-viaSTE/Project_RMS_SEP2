package client.core;

import client.model.table.TableManagement;
import client.view.login.LoginViewModel;
import client.view.table.TableViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private TableViewModel tableViewModel;
    private TableManagement model;


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
            tableViewModel = new TableViewModel(model);
        }
        return tableViewModel;
    }
    }


