package server.model.create;

public class CreateHandlerManager implements CreateHandler {
    private CreateHandler createHandler;

    public CreateHandlerManager() {
        createHandler = new CreateHandlerManager();
    }

    @Override
    public String addUser(String username, String password, String userType) {
        return createHandler.addUser(username, password, userType);
    }
}
