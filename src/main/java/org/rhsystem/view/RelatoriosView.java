package org.rhsystem.view;

import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;

import javax.swing.plaf.TableHeaderUI;
import java.util.Map;
import java.util.Scanner;

public class RelatoriosView {

    static Scanner input = new Scanner(System.in);
    public static int menuRrlatorios(){
        System.out.println("\n|| -------------- RELATÓRIOS --------------||");
        System.out.println("|| 1 - TOTAL DE USUÁRIOS EXISTENTES (ATIVOS)");
        System.out.println("|| 2 - TOTAL DE CARGOS EXISTENTES");
        System.out.println("|| 3 - TOTAL DE DEPARTAMENTOS EXISTENTES");
        System.out.println("|| 4 - QUANTIDADE DE FUNCIONÁRIOS POR CARGO");
        System.out.println("|| 5 - QUANTIDADE DE FUNCIONÁRIOS POR DEPARTAMENTO");
        System.out.println("|| 6 - MÉDIAS SALARIAIS POR CARGO");
        System.out.println("|| 7 - MÉDIAS SALARIAIS POR DEPARTAMENTO");
        System.out.println("|| 0 - VOLTAR AO MENU PRINCIPAL");
        return InputHelper.inputInteger("|| Escolha uma opção: ", input);
    }

    public static void totalUsuariosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ------------------------------------------ ||");
            Thread.sleep(700);
            System.out.println("|| Total de usuários existentes (ativos): " + total);
            Thread.sleep(700);
            System.out.println("|| ------------------------------------------ ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void totalCargosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ------------------------------------------ ||");
            Thread.sleep(700);
            System.out.println("|| Total de cargos existentes: " + total);
            Thread.sleep(700);
            System.out.println("\n|| ------------------------------------------ ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void totalDepartamentosExistentes(int total){
        try{
            Thread.sleep(300);
            System.out.println("\n|| ---------------------------------------------- ||");
            Thread.sleep(700);
            System.out.println("|| Total de departamentos existentes: " + total);
            Thread.sleep(700);
            System.out.println("|| ---------------------------------------------- ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void qntdFuncporDepart(Map<Departamento, Integer> resultados){
        try{
            Thread.sleep(300);
            System.out.println("\n|| -------------------------------------------------- ||");
            Thread.sleep(700);
            System.out.printf("|| %-30s || %-18s ||\n", "DEPARTAMENTO", "TOTAL FUNCIONÁRIOS");
            Thread.sleep(300);

            for (Map.Entry<Departamento, Integer> entry : resultados.entrySet()) {
                String nomeDepartamento = entry.getKey().getNome();
                int totalFuncionarios = entry.getValue();
                System.out.printf("|| %-30s || %-18d ||\n", nomeDepartamento, totalFuncionarios);
                Thread.sleep(200);
            }
            System.out.println("|| -------------------------------------------------- ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void qntdFuncporCargo(Map<Cargo, Integer> resultados){
        try{
            Thread.sleep(300);
            System.out.println("\n|| -------------------------------------------------- ||");
            Thread.sleep(700);
            System.out.printf("|| %-30s || %-18s ||\n", "CARGO", "TOTAL FUNCIONÁRIOS");
            Thread.sleep(300);

            for (Map.Entry<Cargo, Integer> entry : resultados.entrySet()) {
                String nomeCargo = entry.getKey().getNome();
                int totalFuncionarios = entry.getValue();
                System.out.printf("|| %-30s || %-18d ||", nomeCargo, totalFuncionarios);
                Thread.sleep(200);
            }
            System.out.println("|| -------------------------------------------------- ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mediaSalarialPorDepartamento(Map<Departamento, Double> resultados){
        try{
            Thread.sleep(300);
            System.out.println("\n|| -------------------------------------------------- ||");
            Thread.sleep(700);
            System.out.printf("|| %-30s || %-18s ||", "DEPARTAMENTO", "MÉDIA SALARIAL");
            Thread.sleep(300);

            for (Map.Entry<Departamento, Double> entry : resultados.entrySet()) {
                String nomeDepartamento = entry.getKey().getNome();
                double mediaSalarial = entry.getValue();
                System.out.printf("|| %-30s || R$%-15.2f   ||\n", nomeDepartamento, mediaSalarial);
                Thread.sleep(200);
            }
            System.out.println("|| -------------------------------------------------- ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mediaSalarialPorCargo(Map<Cargo, Double> resultados){
        try{
            Thread.sleep(300);
            System.out.println("\n|| -------------------------------------------------- ||");
            Thread.sleep(700);
            System.out.printf("|| %-30s || %-18s ||\n", "CARGO", "MÉDIA SALARIAL");
            Thread.sleep(300);

            for (Map.Entry<Cargo, Double> entry : resultados.entrySet()) {
                String nomeCargo = entry.getKey().getNome();
                double mediaSalarial = entry.getValue();
                System.out.printf("|| %-30s || R$%-15.2f   ||\n", nomeCargo, mediaSalarial);
                Thread.sleep(200);
            }
            System.out.println("|| -------------------------------------------------- ||");
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
