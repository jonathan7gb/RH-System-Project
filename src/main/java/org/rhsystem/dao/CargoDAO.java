package org.rhsystem.dao;

import org.rhsystem.model.Cargo;
import org.rhsystem.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    public static void cadastrarCargo(Cargo cargo) throws SQLException{
        String comando = "INSERT INTO cargo (nome, descricao) VALUES (?, ?)";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());
            stmt.executeUpdate();
        }
    }

    public static void editarCargo(Cargo cargo) throws SQLException{
        String comando = "UPDATE cargo SET nome = ?, descricao = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());
            stmt.setInt(3, cargo.getId());
            stmt.executeUpdate();
        }
    }

    public static List<Cargo> listarCargos() throws SQLException{
        String comando = "SELECT * FROM cargo";
        List<Cargo> cargos = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cargo cargo = new Cargo(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                cargos.add(cargo);
            }
        }
        return cargos;
    }

    public static Cargo buscarCargoPorId(int id) throws SQLException{
        String comando = "SELECT * FROM cargo WHERE id = ?";
        Cargo cargo = null;

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                cargo = new Cargo(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
            }
        }
        return cargo;
    }
}
