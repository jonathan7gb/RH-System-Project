package org.rhsystem.dao;

import org.rhsystem.model.HistoricoSaida;
import org.rhsystem.DBConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HistoricoSaidaDAO {

    public static void salvarHistorico(HistoricoSaida historico) throws SQLException {
        String comando = "INSERT INTO historico_saida (usuario_id, data_saida, motivo, observacoes) VALUES (?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, historico.getUsuarioId());
            stmt.setDate(2, Date.valueOf(historico.getDataSaida()));
            stmt.setString(3, historico.getMotivo());
            stmt.setString(4, historico.getObservacoes());
            stmt.executeUpdate();
        }
    }

    public static List<HistoricoSaida> listarUsuariosInativos() throws SQLException {
        String comando = "SELECT * FROM historico_saida ORDER BY data_saida DESC";
        List<HistoricoSaida> historicoSaidas = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                HistoricoSaida historico = new HistoricoSaida(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_saida").toLocalDate(),
                        rs.getString("motivo"),
                        rs.getString("observacoes")
                );
                historicoSaidas.add(historico);
            }
        }
        return historicoSaidas;
    }

    public static HistoricoSaida buscarHistoricoPorId(int id) throws SQLException {
        String comando = "SELECT * FROM historico_saida WHERE id = ?";
        HistoricoSaida historico = null;

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                historico = new HistoricoSaida(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_saida").toLocalDate(),
                        rs.getString("motivo"),
                        rs.getString("observacoes")
                );
            }
        }
        return historico;
    }

    public static HistoricoSaida buscarPorUsuarioId(int usuarioId) throws SQLException {
        String comando = "SELECT * FROM historico_saida WHERE usuario_id = ?";
        HistoricoSaida historico = null;

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                historico = new HistoricoSaida(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_saida").toLocalDate(),
                        rs.getString("motivo"),
                        rs.getString("observacoes")
                );
            }
        }
        return historico;
    }
}