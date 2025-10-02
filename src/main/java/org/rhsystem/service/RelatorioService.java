package org.rhsystem.service;

import org.rhsystem.dao.RelatorioDAO;
import org.rhsystem.view.MessagesHelper;
import org.rhsystem.view.RelatoriosView;

import java.sql.SQLException;

public class RelatorioService {

    public static void totalUsuariosExistentes(){
        try{
            int total = RelatorioDAO.totalUsuariosExistentes();
            RelatoriosView.totalUsuariosExistentes(total);
        }catch(SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }

    public static void totalCargosExistentes(){
        try{
            int total = RelatorioDAO.totalCargosExistentes();
            RelatoriosView.totalCargosExistentes(total);
        }catch(SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }

    public static void totalDepartamentosExistentes(){
        try{
            int total = RelatorioDAO.totalDepartamentosExistentes();
            RelatoriosView.totalDepartamentosExistentes(total);
        }catch(SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }
}
