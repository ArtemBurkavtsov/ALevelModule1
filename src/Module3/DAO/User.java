package src.Module3.DAO;

import java.util.List;

public interface User {
    void save(User user);
    User getById(Long id);
    List<User> getAll();
}
