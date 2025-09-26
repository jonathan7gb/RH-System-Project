package org.rhsystem.view;

import java.util.Scanner;

public class LoginView {

    static Scanner input = new Scanner(System.in);

    public static String interfaceLoginEmail(){
        System.out.println("\n|| ------- Login ------- ||");
        return InputHelper.inputString("insira seu EMAIL: ", input);
    }

    public static String interfaceLoginPassword(){
        return InputHelper.inputString("insira seu SENHA: ", input);
    }
}
