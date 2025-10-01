package org.rhsystem.model.validations;

import org.rhsystem.view.InputHelper;
import org.rhsystem.view.MessagesHelper;

import java.util.Scanner;

public class SenhaValidate {
    static Scanner input = new Scanner(System.in);

    public static String validarSenha(String msg) {
        while(true){
            String senha = InputHelper.inputString(msg, input);
            if (senha.length() < 8) {
                MessagesHelper.error("A senha deve ter no mínimo 8 caracteres!");
            }else if (!senha.matches(".*[0-9].*")) {
                MessagesHelper.error("A senha deve ter pelo menos 1 número!");
            }else if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                MessagesHelper.error("A senha deve ter pelo menos 1 caractere especial!");
            }else{
                return senha;
            }
        }
    }
}
