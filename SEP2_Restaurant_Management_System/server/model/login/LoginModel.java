package server.model.login;

public interface LoginModel {
    String login(String username, String password);

    String signUp(String userName, String password);
}
