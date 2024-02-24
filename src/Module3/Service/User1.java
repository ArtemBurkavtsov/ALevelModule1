package src.Module3.Service;

import java.util.List;

public interface User1 {
    void createUser(User1 user);
    User1 getUserById(Long id);
    List<User1> getAllUsers();
}
