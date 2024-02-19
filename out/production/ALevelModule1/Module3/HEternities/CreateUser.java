package src.Module3.HEternities;

import java.util.Optional;

public class CreateUser {
    UserDAO userDAO = UserDAO.getInstance();
    private static void createUser(UserDAO UserDAO) {
        User user = new User();
        user.setFullName("Tema");
        UserDAO.create(user);
        System.out.println(user);
    }
    private static void updateUser(UserDAO UserDAO) {
        Optional<User> getUser = userDao.getById(8L);
        if (getUser.isPresent()) {
            User updateUser = getUser.get();
            updateUser.setFullName("T-1000");
            Optional<User> update = userDao.update(updateUser);
            System.out.println(update);
        }
    }
}
