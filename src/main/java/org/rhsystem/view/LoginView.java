package org.rhsystem.view;

import java.util.Scanner;

public class LoginView {

    static Scanner input = new Scanner(System.in);

    public static String interfaceLoginEmail(){
        System.out.println("\n|| ------- Login ------- ||");
        return InputHelper.inputString("|| Insira seu E-MAIL: ", input);
    }

    public static String interfaceLoginPassword(){
        return InputHelper.inputString("|| Insira sua SENHA: ", input);
    }
}
