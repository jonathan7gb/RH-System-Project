package org.rhsystem.controller;

import org.rhsystem.dao.LoginDAO;
import org.rhsystem.model.Usuario;
import org.rhsystem.model.enums.TipoUsuario;
import org.rhsystem.view.LoginView;
import org.rhsystem.view.MessagesHelper;

import java.sql.SQLException;

public class MenuPrincipalController {

    public static void menuPrincipalController(){

        Usuario usuario = null;

       do {
           String email = LoginView.interfaceLoginEmail();
           String senha = LoginView.interfaceLoginPassword();

           try {
               usuario = LoginDAO.checarUsuario(email, senha);
           } catch (SQLException e) {
               MessagesHelper.error(e.getMessage());
           }
           if(usuario == null){
               MessagesHelper.error("Usuário ou Senha Incorretos");
           }else{
               if (usuario.getTipoUsuario() == TipoUsuario.RH){
                   System.out.println("\n|| ---- LOGADO COM SUCESSO ---- ||");
                   RHController.rhController();
               } else if (usuario.getTipoUsuario() == TipoUsuario.FUNCIONARIO){
                   System.out.println("\n|| ---- LOGADO COM SUCESSO ---- ||");
                   FuncionarioController.funcionarioController(usuario);
               } else {
                   MessagesHelper.error("Erro ao encontrar usuário");
               }
           }

       } while (true);
    }
}
