package org.rhsystem.view;

import java.util.Scanner;

public class CargoView {

    static Scanner input = new Scanner(System.in);

    public static int menuCargo(){
        System.out.print("\n\n----- Cargo -----\n\n");

        System.out.println("1 - Cadastrar Cargo");
        System.out.println("2 - Editar Cargo");
        System.out.println("3 - Listar Cargos");
        System.out.println("4 - Buscar Cargo");
        System.out.println("0 - Voltar ao Menu Principal");
        int opcao = InputHelper.inputInteger("Escolha uma opção: ", input);

        return opcao;
    }
}
