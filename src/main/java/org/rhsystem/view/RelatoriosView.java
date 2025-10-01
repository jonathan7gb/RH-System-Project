package org.rhsystem.view;

import java.util.Scanner;

public class RelatoriosView {

    static Scanner input = new Scanner(System.in);
    public static int menuRrlatorios(){
        System.out.println("\n|| ------ RELATÓRIOS ------||");
        System.out.println("|| 1 - TOTAL DE USUÁRIOS EXISTENTES (ATIVOS)");
        System.out.println("|| 2 - TOTAL DE CARGOS EXISTENTES");
        System.out.println("|| 3 - TOTAL DE DEPARTAMENTOS EXISTENTES");
        System.out.println("|| 4 - QUANTIDADE DE FUNCIONÁRIOS POR DEPARTAMENTO");
        System.out.println("|| 5 - QUANTIDADE DE FUNCIONÁRIOS POR CARGO");
        System.out.println("|| 6 - MÉDIAS SALARIAIS POR DEPARTAMENTO");
        System.out.println("|| 6 - MÉDIAS SALARIAIS POR CARGO");
        System.out.println("|| 0 - VOLTAR AO MENU PRINCIPAL");
        return InputHelper.inputInteger("|| Escolha uma opção: ", input);
    }
}
