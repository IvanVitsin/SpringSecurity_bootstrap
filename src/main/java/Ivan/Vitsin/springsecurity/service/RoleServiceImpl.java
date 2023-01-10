package Ivan.Vitsin.springsecurity.service;

import Ivan.Vitsin.springsecurity.model.Role;
import Ivan.Vitsin.springsecurity.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
