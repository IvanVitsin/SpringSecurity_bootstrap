package spring_boot_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring_boot_security.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);
    User getUserById(int id);
    User getUserByName(String userName);

}
