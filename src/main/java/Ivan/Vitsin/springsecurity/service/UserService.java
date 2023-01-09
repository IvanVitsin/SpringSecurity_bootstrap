package Ivan.Vitsin.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import Ivan.Vitsin.springsecurity.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);
    User getUserById(int id);
    User getUserByName(String userName);

}
