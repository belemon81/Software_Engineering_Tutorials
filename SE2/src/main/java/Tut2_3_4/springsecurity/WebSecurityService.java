package Tut2_3_4.springsecurity;

import Tut2_3_4.model.Role;
import Tut2_3_4.model.User;
import Tut2_3_4.repository.RoleRepository;
import Tut2_3_4.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebSecurityService implements UserDetailsService, ISecurityService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User createUser(String username, String password, String email, Role... roles) {
        User user = new User(username, encoder.encode(password), email);
        for (Role role : roles) {
            user.addRole(role);
        }
        return user;
    }

    @Override
    @Transactional
    public void generateUsersRoles() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        if (roleRepository.count() == 0) {
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            roleRepository.flush();
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = createUser("admin", "999999", "admin@gmail.com", roleAdmin, roleUser);
            userRepository.save(admin);
            userRepository.flush();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user!");
        }
        return user.get();
    }

}