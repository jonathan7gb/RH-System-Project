package org.rhsystem.dao;

import org.rhsystem.model.Departamento;
import org.rhsystem.DBConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    public static void cadastrarDepartamento(Departamento departamento) throws SQLException {
        String comando = "INSERT INTO departamento (nome, descricao) VALUES (?, ?)";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getDescricao());
            stmt.executeUpdate();
        }
    }

    public static void editarDepartamento(Departamento departamento) throws SQLException{
        String comando = "UPDATE departamento SET nome = ?, descricao = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getDescricao());
            stmt.setInt(3, departamento.getId());
            stmt.executeUpdate();
        }
    }

    public static List<Departamento> listarDepartamentos() throws SQLException{
        String comando = "SELECT * FROM departamento";
        List<Departamento> departamentos = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Departamento departamento = new Departamento(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                departamentos.add(departamento);
            }
        }
        return departamentos;
    }

    public static Departamento buscarDepartamentoPorId(int id) throws SQLException{
        String comando = "SELECT * FROM departamento WHERE id = ?";
        Departamento departamento = null;

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                departamento = new Departamento(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
            }
        }
        return departamento;
    }
}
