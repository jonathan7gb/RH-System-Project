package org.rhsystem.view;

import java.util.Scanner;

public class FuncionarioView {
    static Scanner input = new Scanner(System.in);


    // MENU FUNCIONARIO
    public static void menuFuncionario() {
        System.out.print("\n\n----- Funcionário -----\n\n");

        System.out.println("1- Visualizar Informações");
        System.out.println("2- Visualizar Colegas de Departamento");
        System.out.println("3- Trocar Senha");
        System.out.println("0- Sair do Sistema");
        int opcao = input.nextInt();

        switch (opcao) {

            case 1: {
                break;
            }

            case 2: {
                break;
            }

            case 3: {
                break;
            }

            case 4: {
                System.out.println("Saindo do Sistema...");
                break;
            }
        }
    }


    // VISUALIZAR INFORMAÇÕES
    public static void visualizarInformacoes() {
        System.out.println("\n\n----- Visualizar Informações -----\n\n");

        System.out.println("Nome: ");
        System.out.println("CPF: ");
        System.out.println("Data de Nascimento: ");
        System.out.println("Cargo: ");
        System.out.println("Salário: ");
    }


    // TROCAR DE SENHA
    public static void trocarSenha() {
        System.out.println("\n\n----- Trocar de Senha -----\n\n");

        System.out.println("Insira a senha atual: ");
        String senhaAtual = input.nextLine();

        System.out.println("\nInsira a nova senha: ");
        String novaSenha = input.nextLine();

        System.out.println("\nConfirme a nova senha: ");
        String confirmacaoNovaSenha = input.nextLine();


    }
}

