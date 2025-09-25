package org.rhsystem.view;

import org.rhsystem.model.Usuario;

import java.util.Objects;
import java.util.Scanner;

public class FuncionarioView {
    static Scanner input = new Scanner(System.in);

    // MENU FUNCIONARIO
    public static int menuFuncionario() {
        System.out.println("\n|| ----- Funcionário ----- ||");

        System.out.println("|| 1- Visualizar Informações");
        System.out.println("|| 2- Visualizar Colegas de Departamento");
        System.out.println("|| 3- Trocar Senha");
        System.out.println("|| 0- Sair do Sistema");
        return InputHelper.inputInteger("|| Escolha uma opção: ", input);
    }


    // VISUALIZAR INFORMAÇÕES
    public static void visualizarInformacoes(Usuario usuario) {
        System.out.println("\n|| ----- Visualizar Informações ----- ||");

        System.out.println("|| Nome: "+ usuario.getNomeCompleto());
        System.out.println("|| CPF: "+ usuario.getCPF());
        System.out.println("|| Data de Nascimento: "+ usuario.getDataNascimento());
        System.out.println("|| Cargo: "+ usuario.getCargo().getNome());
        System.out.println("|| Departamento: "+ usuario.getDepartamento().getNome());
        System.out.println("|| Salário: "+ usuario.getSalario());
    }


    // TROCAR DE SENHA
    public static String inserirSenhaAtual() {
        System.out.println("\n|| ----- Trocar de Senha ----- ||");

        return InputHelper.inputString("|| Insira a senha atual", input);
    }


    public static String inserirSenhaNova() {
        String novaSenha = InputHelper.inputString("|| Insira a nova senha", input);

        if (novaSenha.length() < 8) {
            MessagesHelper.error("A senha deve ter no mínimo 8 caracteres!");
            return null;
        }

        if (!novaSenha.matches(".*[0-9].*")) {
            MessagesHelper.error("A senha deve ter pelo menos 1 número!");
            return null;
        }

        if (!novaSenha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            MessagesHelper.error("A senha deve ter pelo menos 1 caractere especial!");
            return null;
        }
        String confirmacaoNovaSenha = InputHelper.inputString("|| Confirme a nova senha:", input);

        if(Objects.equals(confirmacaoNovaSenha, novaSenha)) {
            return confirmacaoNovaSenha;

        }else {
            return null;
        }

    }
}

