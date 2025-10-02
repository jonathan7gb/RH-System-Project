package org.rhsystem.dao;

import org.rhsystem.DBConnection.DatabaseConnection;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.enums.StatusUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RelatorioDAO {

    public static int totalUsuariosExistentes() throws SQLException{
        String comando = "SELECT COUNT(*) FROM usuario WHERE statusUsuario = ?";
        int totalUsuariosExistentes = 0;
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, "Ativo");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                totalUsuariosExistentes = rs.getInt(1);
            }
        }

        return totalUsuariosExistentes;
    }

    public static int totalCargosExistentes() throws SQLException{
        String comando = "SELECT COUNT(*) FROM cargo";
        int totalCargosExistentes = 0;
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                totalCargosExistentes = rs.getInt(1);
            }
        }

        return totalCargosExistentes;
    }

    public static int totalDepartamentosExistentes() throws SQLException{
        String comando = "SELECT COUNT(*) FROM departamento";
        int totalDepartamentosExistentes = 0;
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                totalDepartamentosExistentes = rs.getInt(1);
            }
        }

        return totalDepartamentosExistentes;
    }

    public static Map<Departamento, Integer> getQuantidadeFuncionarioPorDepartamento() throws SQLException {
        Map<Departamento, Integer> resultados = new LinkedHashMap<>(); // Mantém a ordem

        String sql = "SELECT d.id, d.nome, COUNT(u.id) AS total_func FROM departamento d " +
                "LEFT JOIN usuario u ON d.id = u.id_departamento " +
                "GROUP BY d.id, d.nome ORDER BY d.nome";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Departamento d = new Departamento();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));

                int contagem = rs.getInt("total_func");

                resultados.put(d, contagem);
            }
        }
        return resultados;
    }
//
//    public static Map<Cargo, Integer> totalFuncPorCargo() throws SQLException{
//        return Map<Cargo, Integer> funcPorCargo = new HashMap<>();
//    }
//
//    public static Map<Departamento, Double> mediaSalarialPorDepartamento() throws SQLException{
//        return Map<Departamento, Integer> funcPorDepartamento = new HashMap<>();
//    }
//
//    public static Map<Cargo, Double> mediaSalarialPorCargo() throws SQLException{
//        return Map<Cargo, Integer> funcPorCargo = new HashMap<>();
//    }
}
