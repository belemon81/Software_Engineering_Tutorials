package Tut2_3_4.springsecurity;

import jakarta.transaction.Transactional;

public interface ISecurityService {

    @Transactional
    void generateUsersRoles();
}
