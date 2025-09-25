package org.rhsystem.dao;

import org.rhsystem.DBConnection.DatabaseConnection;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrocarSenhaDAO {

    public static boolean verificarSenha(Usuario usuario, String senha) throws SQLException {
        String comando = "SELECT email, senha FROM usuario WHERE email = ? AND senha = ?";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }return false;
    }

    public static boolean alterarSenha(String Novasenha, Usuario usuario) throws SQLException {
        String comando = "UPDATE usuario SET senha = ? WHERE email = ?";

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, Novasenha);
            stmt.executeUpdate();
            return true;
        }
    }
}
