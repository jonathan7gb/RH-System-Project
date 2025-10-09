package org.rhsystem.model.validations;

import org.rhsystem.view.InputHelper;
import org.rhsystem.view.MessagesHelper;

import java.util.Scanner;

public class EmailValidate {

    static Scanner input = new Scanner(System.in);

    public static String emailValidate() {
        // Regex para validar um formato de e-mail comum.
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        while (true) {
            String email = InputHelper.inputString("|| Email do usuário: ", input);

            if (email.isEmpty()) {
                MessagesHelper.error("O e-mail não pode ser vazio!");
                continue;
            }

            // O método matches() verifica se a string corresponde à expressão regular
            if (email.matches(emailRegex)) {
                return email;
            } else {
                MessagesHelper.error("Formato de e-mail inválido! Ex: teste@teste.com\n");

            }
        }
    }
}
