package client.mediator;

public class ClientHandler implements Client{
    @Override
    public void login(String hi) {
        System.out.println("In Client " + hi);
    }
}
