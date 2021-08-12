package com.stana.utility;

import org.jasypt.util.text.AES256TextEncryptor;
import java.io.Console;

public class JaysptStringEncryptor {
    public JaysptStringEncryptor() {
        AES256TextEncryptor aes256TextEncryptor = new AES256TextEncryptor();
        aes256TextEncryptor.setPassword("island");

        Console console = System.console();
        console.printf("Please enter your username : ");
        char[] usernameChars = console.readPassword();
        String usernameString = new String(usernameChars);
        console.printf("Please enter your password : ");
        char[] passwordChars = console.readPassword();
        String passwordString = new String(passwordChars);

        String username = aes256TextEncryptor.encrypt(usernameString);
        String password = aes256TextEncryptor.encrypt(passwordString);
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
