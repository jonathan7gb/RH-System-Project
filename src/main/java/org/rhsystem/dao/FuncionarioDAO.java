package org.rhsystem.dao;

import org.rhsystem.DBConnection.DatabaseConnection;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.Usuario;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static List<Usuario> visualizarColegasDepartamento(int id_departamento) throws SQLException {
        String comando = "SELECT id, nomeCompleto, id_cargo FROM usuario WHERE id_departamento = ?";
        List<Usuario> usuarios = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, id_departamento);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                Cargo cargo = CargoDAO.buscarCargoPorId(rs.getInt("id_cargo"));
                String  nomeCompleto = rs.getString("nomeCompleto");

                Usuario usuario = new Usuario(id, nomeCompleto, cargo);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
}
