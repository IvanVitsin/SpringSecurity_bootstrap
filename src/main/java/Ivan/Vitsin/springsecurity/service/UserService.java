package Ivan.Vitsin.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import Ivan.Vitsin.springsecurity.model.User;

import java.util.List;

public interface UserService {


    User findById(int id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(int id);

    User findUserByEmail(String email);

}
