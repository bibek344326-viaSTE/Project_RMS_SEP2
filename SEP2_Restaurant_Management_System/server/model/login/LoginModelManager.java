package server.model.login;

public class LoginModelManager implements LoginModel {
    @Override
    public String login(String username, String password) {
            System.out.println("Inside loModManager : " + username + "  "+ password);
        return "From server " + username + " " + password;
    }

    @Override
    public String signUp(String userName, String password) {
        System.out.println(userName +" " +password);
        return "true";
    }
}
