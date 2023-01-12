package Ivan.Vitsin.springsecurity.configs;

import Ivan.Vitsin.springsecurity.model.Role;
import Ivan.Vitsin.springsecurity.model.User;
import Ivan.Vitsin.springsecurity.service.RoleService;
import Ivan.Vitsin.springsecurity.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataLoader {

    private final UserService userService;
    private final RoleService roleService;

    public DataLoader(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    private void defaultDbValue() {

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        if (roleService.findRoleByName(roleUser.getName()) == null) {
            roleService.saveRole(roleUser);
        }

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        if (roleService.findRoleByName(roleAdmin.getName()) == null) {
            roleService.saveRole(roleAdmin);
        }

        User admin = new User();
        admin.setFirstName("admin");
            admin.setLastName("admin");
        admin.setAge(18);
        admin.setEmail("admin@mail.ru");
        admin.setPassword("admin");
        admin.setRoles(Set.of(roleAdmin, roleUser));
        if (userService.findUserByEmail(admin.getEmail()) == null) {
            userService.saveUser(admin);
        }

        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setAge(18);
        user.setEmail("user@mail.ru");
        user.setPassword("user");
        user.setRoles(Set.of(roleUser));
        if (userService.findUserByEmail(user.getEmail()) == null) {
            userService.saveUser(user);
        }
    }

}

