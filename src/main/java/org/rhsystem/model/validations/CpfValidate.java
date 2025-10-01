package org.rhsystem.model.validations;

import org.rhsystem.view.InputHelper;
import org.rhsystem.view.MessagesHelper;

import java.util.Scanner;

public class CpfValidate {

    static Scanner input = new Scanner(System.in);

    public static String cpfValidate() {
        // Regex para validar o formato xxx.xxx.xxx-xx
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        while (true) {
            String cpf = InputHelper.inputString("|| CPF do usuário: ", input);

            if (cpf.isEmpty()) {
                MessagesHelper.error("O CPF não pode ser vazio!");
                continue;
            }

            // O método matches() verifica se a string corresponde à expressão regular
            if (cpf.matches(cpfRegex)) {
                return cpf;
            } else {
                MessagesHelper.error("Formato de CPF inválido! Use o formato xxx.xxx.xxx-xx");
            }
        }
    }
}
