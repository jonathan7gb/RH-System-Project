package org.rhsystem.service;

import org.rhsystem.dao.RelatorioDAO;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.view.MessagesHelper;
import org.rhsystem.view.RelatoriosView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public static void qntdFuncPorDepart(){
        try{
            Map<Departamento, Integer> resultados = new LinkedHashMap<>();
            resultados = RelatorioDAO.getQuantidadeFuncionarioPorDepartamento();
            if(resultados.isEmpty()){
                MessagesHelper.error("Nada encontrado! Algum erro ocorreu na busca!");
            }else{
                RelatoriosView.qntdFuncporDepart(resultados);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }

    public static void qntdFuncPorCargo(){
        try{
            Map<Cargo, Integer> resultados = new LinkedHashMap<>();
            resultados = RelatorioDAO.getQuantidadeFuncionarioPorCargo();
            if(resultados.isEmpty()){
                MessagesHelper.error("Nada encontrado! Algum erro ocorreu na busca!");
            }else{
                RelatoriosView.qntdFuncporCargo(resultados);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }

    public static void mediaSalarialPorDepartamento(){
        try{
            Map<Departamento, Double> resultados = new LinkedHashMap<>();
            resultados = RelatorioDAO.mediaSalarialPorDepartamento();
            if(resultados.isEmpty()){
                MessagesHelper.error("Nada encontrado! Algum erro ocorreu na busca!");
            }else{
                RelatoriosView.mediaSalarialPorDepartamento(resultados);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }

    public static void mediaSalarialPorCargo(){
        try{
            Map<Cargo, Double> resultados = new LinkedHashMap<>();
            resultados = RelatorioDAO.mediaSalarialPorCargo();
            if(resultados.isEmpty()){
                MessagesHelper.error("Nada encontrado! Algum erro ocorreu na busca!");
            }else{
                RelatoriosView.mediaSalarialPorCargo(resultados);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar os dados: "+ e.getMessage());
        }
    }
}
