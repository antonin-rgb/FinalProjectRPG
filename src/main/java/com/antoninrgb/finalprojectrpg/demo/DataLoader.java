/*
package com.antoninrgb.finalprojectrpg.demo;
import com.antoninrgb.finalprojectrpg.model.Role;
import com.antoninrgb.finalprojectrpg.model.User;
import com.antoninrgb.finalprojectrpg.service.RoleService;
import com.antoninrgb.finalprojectrpg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("john", "1234"));
        userService.saveUser(new User("james", "1234"));

        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
    }
}
*/