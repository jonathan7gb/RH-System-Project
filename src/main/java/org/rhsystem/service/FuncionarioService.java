package org.rhsystem.service;

import org.rhsystem.dao.FuncionarioDAO;
import org.rhsystem.dao.TrocarSenhaDAO;
import org.rhsystem.model.Usuario;
import org.rhsystem.view.FuncionarioView;
import org.rhsystem.view.MessagesHelper;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioService {

    public static void visualizarColegasDepartamento(Usuario usuario){
        try{
            List<Usuario> colegas = FuncionarioDAO.visualizarColegasDepartamento(usuario.getDepartamento().getId());
            if(!colegas.isEmpty()){
                MessagesHelper.error("Nenhum Colega de Departamento encontrado!");
            }else{
                FuncionarioView.visualizarColegasDepartamento(colegas);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao visualizar colegas de departamento: " + e.getMessage());
        }
    }

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
