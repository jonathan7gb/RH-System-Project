package org.rhsystem.service;

import org.rhsystem.dao.TrocarSenhaDAO;
import org.rhsystem.model.Usuario;
import org.rhsystem.view.FuncionarioView;
import org.rhsystem.view.MessagesHelper;

import java.sql.SQLException;

public class FuncionarioService {

    public static void alterarSenha(Usuario usuario) {
        try {
            String senhaAtual = FuncionarioView.inserirSenhaAtual();
            boolean senhaValida = TrocarSenhaDAO.verificarSenha(usuario, senhaAtual);

            if(!senhaValida){
                MessagesHelper.error("Senha atual incorreta");
            }else{
                String novaSenha = FuncionarioView.inserirSenhaNova();
                if(novaSenha == null){
                    MessagesHelper.error("As senhas não coincidem / Erro de validação");
                }else{
                    boolean senhaAlteradaComSucesso = TrocarSenhaDAO.alterarSenha(novaSenha, usuario);

                    if(senhaAlteradaComSucesso){
                        MessagesHelper.success("Senha alterada com sucesso");
                    }else{
                        MessagesHelper.error("Senha não foi alterada!");
                    }
                }
            }
        }catch (SQLException e) {
            MessagesHelper.error(e.getMessage());
        }
    }
}
