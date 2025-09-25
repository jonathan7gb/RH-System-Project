package org.rhsystem.service;

import org.rhsystem.dao.DepartamentoDAO;
import org.rhsystem.model.Departamento;
import org.rhsystem.view.DepartamentoView;
import org.rhsystem.view.MessagesHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoService {

    public static void registrarDepartamento() {
        try{
            Departamento departamento = DepartamentoView.cadastrarDepartamento();
            if(departamento != null) {
                DepartamentoDAO.cadastrarDepartamento(departamento);
                MessagesHelper.success("Departamento cadastrado com sucesso!");
            }else{
                MessagesHelper.error("Dados inválidos. Departamento não cadastrado.");
            }
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void editarDepartamento(){
        try{
            int id = DepartamentoView.buscarDepartamento();
            Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(id);
            if(departamento != null){
                departamento = DepartamentoView.editarDepartamento(departamento);
                DepartamentoDAO.editarDepartamento(departamento);
                MessagesHelper.success("Departamento editado com sucesso!");
            }else{
                MessagesHelper.error("Departamento não encontrado.");
            }
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void listarDepartamentos(){
        try{
            DepartamentoView.listarDepartamentos(DepartamentoDAO.listarDepartamentos());
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void buscarDepartamento(){
        try{
            int id = DepartamentoView.buscarDepartamento();
            List<Departamento> departamentos = new ArrayList<>();
            Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(id);
            departamentos.add(departamento);
            DepartamentoView.listarDepartamentos(departamentos);
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }
}
