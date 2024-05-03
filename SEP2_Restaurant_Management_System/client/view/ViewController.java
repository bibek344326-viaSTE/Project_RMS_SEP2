package client.view;

import client.core.ViewModelFactory;
import javafx.scene.layout.Region;

public interface ViewController {
    public void init (ViewModelFactory viewModelFactory, ViewHandler viewHandler);
}
