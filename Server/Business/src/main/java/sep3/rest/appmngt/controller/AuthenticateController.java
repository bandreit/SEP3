package sep3.rest.appmngt.controller;

import sep3.rest.appmngt.model.BusinessOwner;
import sep3.rest.appmngt.model.User;
import sep3.rest.appmngt.service.BusinessOwnerService;
import sep3.rest.appmngt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@RestController
@RequestMapping("/SEP3")
public class AuthenticateController {
    @Autowired
    private UserService userService;

    @GetMapping("/validate")
    public ResponseEntity<User> ValidateUser(@RequestParam String username, @RequestParam String password) {
        try {
            User user = userService.ValidateUser(username, password);

            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            if (!user.getPassword().equals(password)) {
                return ResponseEntity.status(401).build();
            }

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
