package org.rhsystem.view;

import java.util.Scanner;

public class MenuPrincipalView {

    static Scanner input = new Scanner(System.in);

    public static int menuPrincipal(){
        System.out.println("\n|| ------ RH SOLUTIONS ------||");
        System.out.println("|| 1 - USUÁRIOS");
        System.out.println("|| 2 - CARGOS");
        System.out.println("|| 3 - DEPARTAMENTOS");
        System.out.println("|| 4 - RELATÓRIOS");
        System.out.println("|| 0 - SAIR DO SISTEMA");
        return InputHelper.inputInteger("|| Escolha uma opção: ", input);
    }
}
