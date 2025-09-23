package org.rhsystem.dao;

import org.rhsystem.model.Cargo;

import java.sql.SQLException;

public class CargoDAO {

    public static void cadastrarCargo(Cargo cargo) throws SQLException{
        String comando = "INSERT INTO cargo (nome, descricao) VALUES (?, ?)";
    }
}
