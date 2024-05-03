package client.core;

import client.model.table.TableModel;
import client.view.login.LoginViewModel;
import client.view.table.TableViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private TableViewModel tableViewModel;
    private TableModel model;
    private ViewState viewState;



    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        this.viewState = new ViewState();
    }

    public LoginViewModel getLogInViewModel() {
        if (loginViewModel == null){
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }
    public TableViewModel getTableViewModel() {
        if (tableViewModel  == null){
            tableViewModel = new TableViewModel(modelFactory, viewState);
        }
        return tableViewModel;
    }
    }


