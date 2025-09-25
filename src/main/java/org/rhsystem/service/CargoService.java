package org.rhsystem.service;

import org.rhsystem.dao.CargoDAO;
import org.rhsystem.model.Cargo;
import org.rhsystem.view.CargoView;
import org.rhsystem.view.MessagesHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoService {

    public static void registrarCargo() {
       try{
           Cargo cargo = CargoView.cadastrarCargo();
              if(cargo != null) {
                  CargoDAO.cadastrarCargo(cargo);
                  MessagesHelper.success("Cargo cadastrado com sucesso!");
              }else{
                    MessagesHelper.error("Dados inválidos. Cargo não cadastrado.");
              }
       }catch (SQLException e){
           MessagesHelper.error(e.getMessage());
       }
    }

    public static void editarCargo(){
        try{
            int id = CargoView.buscarCargo();
            Cargo cargo = CargoDAO.buscarCargoPorId(id);
            if(cargo != null){
                cargo = CargoView.editarCargo(cargo);
                CargoDAO.editarCargo(cargo);
                MessagesHelper.success("Cargo editado com sucesso!");
            }else{
                MessagesHelper.error("Cargo não encontrado.");
            }
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void listarCargos(){
        try{
            CargoView.listarCargos(CargoDAO.listarCargos());
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public static void buscarCargo(){
        try{
            int id = CargoView.buscarCargo();
            List<Cargo> cargos = new ArrayList<>();
            Cargo cargo = CargoDAO.buscarCargoPorId(id);
            cargos.add(cargo);
            CargoView.listarCargos(cargos);
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }
}
