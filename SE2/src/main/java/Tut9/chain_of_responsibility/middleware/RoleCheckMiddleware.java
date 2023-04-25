package Tut9.chain_of_responsibility.middleware;

/**
 * ConcreteHandler. Checks a user's role.
 */
public class RoleCheckMiddleware extends Middleware {
    //TODO: Implement the check() method
    public boolean check(String email, String password) {
    	/*if email = 'admin@example.com' => display welcome message for admin then return true
        else, display welcome message for normal user */
        if (email.equals("admin@example.com")) {
            System.out.println("Welcome ADMIN!");
        } else {
            System.out.println("Welcome USER!");
        }
        return checkNext(email, password);
    }
}