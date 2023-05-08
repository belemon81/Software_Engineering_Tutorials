package Tut2_3_4;

import Tut2_3_4.springsecurity.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private ISecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        securityService.generateUsersRoles();
    }
}