package org.rhsystem.service;

import org.rhsystem.dao.HistoricoSaidaDAO;
import org.rhsystem.dao.RHDAO;
import org.rhsystem.service.HistoricoSaidaService;
import org.rhsystem.model.HistoricoSaida;
import org.rhsystem.model.Usuario;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.view.MessagesHelper;
import org.rhsystem.view.RHView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class RHService {

    public static void cadastrarUsuario(){
        try{
            Usuario usuario = RHView.cadastrarUsuario();
            if (usuario != null){
                RHDAO.cadastrarUsuario(usuario);
                MessagesHelper.success("Usuario cadastrado com sucesso!");
            }else{
                MessagesHelper.error("Dados inválidos. Cargo não cadastrado.");
            }
        }catch (SQLIntegrityConstraintViolationException e){
            MessagesHelper.error("Uma das causas desse erro é valor duplicado. \n|| Então o CPF ou email que você digitou possivelmente já está em uso!!");
        } catch (SQLException e) {
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void editarUsuario(){
            try{
                // Busca o usuário para editar

                int id = RHView.buscarUsuario();
                Usuario usuarioExistente = RHDAO.buscarUsuarioPorId(id);

                if (usuarioExistente == null) {
                    MessagesHelper.error("Usuário não encontrado.");
                    return;
                }


                if (usuarioExistente.getStatusUsuario() == StatusUsuario.INATIVO) {

                    MessagesHelper.error("Não é possível editar usuário inativo. Use a opção de reativar se necessário.");
                    return;
                }


                StatusUsuario statusOriginal = usuarioExistente.getStatusUsuario();


                Usuario usuarioEditado = RHView.editarUsuario(usuarioExistente);

                if (usuarioEditado != null) {

                    if (usuarioEditado.getStatusUsuario() == StatusUsuario.INATIVO && statusOriginal == StatusUsuario.ATIVO) {

                        MessagesHelper.error("Para inativar um usuário, use a opção específica de inativação.");
                        return;
                    }


                    // Salva apenas edições normais

                    RHDAO.editarUsuario(usuarioEditado);
                    MessagesHelper.success("Usuário editado com sucesso!");

                } else {
                    MessagesHelper.error("Falha na edição do usuário.");
                }

            } catch (SQLException e) {
                MessagesHelper.error("Erro ao editar usuário: " + e.getMessage());
            }
        }

    public static void inativarUsuario(){
        try{
            int id = RHView.buscarUsuario();
            Usuario usuarioExistente = RHDAO.buscarUsuarioPorId(id);

            if (usuarioExistente == null) {
                MessagesHelper.error("Usuário não encontrado.");
                return;
            }

            if (usuarioExistente.getStatusUsuario() == StatusUsuario.INATIVO) {

                MessagesHelper.error("Usuário já está inativo.");
                return;
            }

            HistoricoSaida historico = RHView.inativarUsuario(usuarioExistente);

            if (historico != null) {

                usuarioExistente.setStatusUsuario(StatusUsuario.INATIVO);

                RHDAO.editarUsuario(usuarioExistente);

                // Delega para o service específico
                HistoricoSaidaService.salvarHistorico(historico);

                MessagesHelper.success("Usuário inativado e histórico registrado com sucesso!");

            } else {
                MessagesHelper.info("Inativação cancelada pelo usuário.");
            }

        } catch (SQLException e) {
            MessagesHelper.error("Erro ao inativar usuário: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            MessagesHelper.error("Dados inválidos: " + e.getMessage());
        }
    }

    public static void listarUsuario(){
        try{
            RHView.listarUsuario(RHDAO.listarUsuarios());
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void buscarUsuario(){
            try{
                int id = RHView.buscarUsuario();
                Usuario usuario = RHDAO.buscarUsuarioPorId(id);

                if (usuario != null) {
                    List<Usuario> usuarios = new ArrayList<>();
                    usuarios.add(usuario);
                    RHView.listarUsuario(usuarios);
                } else {
                    MessagesHelper.error("Usuário não encontrado.");
                }
            } catch (SQLException e){
                MessagesHelper.error(e.getMessage());
            }
        }

    public static void listarUsuariosInativos(){
        try {
            RHView.listarUsuariosInativos(HistoricoSaidaDAO.listarUsuariosInativos());        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }
}

