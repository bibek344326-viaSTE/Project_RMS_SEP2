package server.model.create;

import java.util.SplittableRandom;

public interface CreateHandler {
    String addUser(String username, String password, String userType);
}
