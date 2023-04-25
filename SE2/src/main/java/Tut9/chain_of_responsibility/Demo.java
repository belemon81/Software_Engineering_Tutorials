package Tut9.chain_of_responsibility;

import Tut9.chain_of_responsibility.middleware.Middleware;
import Tut9.chain_of_responsibility.middleware.RoleCheckMiddleware;
import Tut9.chain_of_responsibility.middleware.ThrottlingMiddleware;
import Tut9.chain_of_responsibility.middleware.UserExistsMiddleware;
import Tut9.chain_of_responsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() throws IOException {
        server = new Server();
        //TODO: Register email & pass for 2 account types: admin & user
        server.register("admin@example.com", "admin1234");
        server.register("user@example.com", "user1234");

        // All checks are linked. Client can build various chains using the same components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            //TODO: Ask for email & password then save to suitable variables
            System.out.println("User's email: ");
            String userEmail = reader.readLine();
            System.out.println("User's password: ");
            String userPassword = reader.readLine();
            //TODO: Try to login to server with given email & password
            //then store the result to variable 'success'
            success = server.logIn(userEmail, userPassword);;
        } while (!success);
    }
}
