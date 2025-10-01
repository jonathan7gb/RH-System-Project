package org.rhsystem.dao;

import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.Usuario;
import org.rhsystem.DBConnection.DatabaseConnection;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginDAO {

    public static Usuario checarUsuario(String email, String senha) throws SQLException{
        String comando = "SELECT * FROM usuario WHERE senha = ? and email = ?";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(comando);

        preparedStatement.setString(1, senha);
        preparedStatement.setString(2, email);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nomeCompleto = rs.getString("nomeCompleto");
            String CPF = rs.getString("CPF");
            String emailUsuario = rs.getString("email");
            LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
            int id_cargo = rs.getInt("id_cargo");
            int id_departamento = rs.getInt("id_departamento");
            Double salario = rs.getDouble("salario");
            LocalDate dataAdmissao = rs.getDate("dataAdmissao").toLocalDate();
            String tipo = rs.getString("tipoUsuario");
            StatusUsuario status = StatusUsuario.valueOf(rs.getString("statusUsuario"));
            String senhaUsuario = rs.getString("senha");

            TipoUsuario tipoUsuario = TipoUsuario.valueOf(tipo);
            Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(id_departamento);
            Cargo cargo = CargoDAO.buscarCargoPorId(id_cargo);
            Usuario usuario = new Usuario (id, CPF, nomeCompleto, emailUsuario, dataNascimento, cargo, departamento, salario, dataAdmissao, tipoUsuario, status, senhaUsuario);
            return usuario;

        }
        return null;
    }

}
