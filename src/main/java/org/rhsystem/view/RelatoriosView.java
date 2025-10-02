package org.rhsystem.view;

import javax.swing.plaf.TableHeaderUI;
import java.util.Scanner;

public class RelatoriosView {

    static Scanner input = new Scanner(System.in);
    public static int menuRrlatorios(){
        System.out.println("\n|| -------------- RELATÓRIOS --------------||");
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

    public static void totalUsuariosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ============================================ ");
            Thread.sleep(700);
            System.out.println("|| Total de usuários existentes (ativos): " + total);
            Thread.sleep(700);
            System.out.println("|| ============================================ ");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void totalCargosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ============================================ ");
            Thread.sleep(700);
            System.out.println("|| Total de cargos existentes: " + total);
            Thread.sleep(700);
            System.out.println("|| ============================================ ");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void totalDepartamentosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ============================================ ");
            Thread.sleep(700);
            System.out.println("|| Total de departamentos existentes: " + total);
            Thread.sleep(700);
            System.out.println("|| ============================================ ");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
