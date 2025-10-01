package org.rhsystem.dao;

import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.Usuario;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;
import org.rhsystem.service.RHService;
import org.rhsystem.DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RHDAO {

    //'comando' para modificação no banco, 'query' para consultas
    public static void cadastrarUsuario(Usuario usuario) throws SQLException{

        String comando = "INSERT INTO usuario (CPF, nomeCompleto, email, dataNascimento, id_cargo, id_departamento, salario, dataAdmissao, tipoUsuario, statusUsuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNomeCompleto());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setInt(5, usuario.getCargo().getId());
            stmt.setInt(6, usuario.getDepartamento().getId());
            stmt.setDouble(7, usuario.getSalario());
            stmt.setDate(8, java.sql.Date.valueOf(usuario.getDataAdmissao()));
            stmt.setString(9, usuario.getTipoUsuario().name());

            stmt.setString(10, usuario.getStatusUsuario().name());

            stmt.setString(11, usuario.getSenha());
            stmt.executeUpdate();
        }
    }

    public static void editarUsuario(Usuario usuario) throws SQLException {

        String comando = "UPDATE usuario SET CPF = ?, nomeCompleto = ?, email = ?, dataNascimento = ?, id_cargo = ?, id_departamento = ?, salario = ?, dataAdmissao = ?, tipoUsuario = ?, statusUsuario = ?, senha = ? WHERE id = ?";


        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando)) {

            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNomeCompleto());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setInt(5, usuario.getCargo().getId());
            stmt.setInt(6, usuario.getDepartamento().getId());
            stmt.setDouble(7, usuario.getSalario());
            stmt.setDate(8, java.sql.Date.valueOf(usuario.getDataAdmissao()));
            stmt.setString(9, usuario.getTipoUsuario().name());

            stmt.setString(10, usuario.getStatusUsuario().name());

            stmt.setString(11, usuario.getSenha());
            stmt.setInt(12, usuario.getId()); // aq seria o WHERE id = ?

            stmt.executeUpdate();
        }
    }

    public static List<Usuario> listarUsuarios() throws SQLException {

        String comando = "SELECT * FROM usuario WHERE statusUsuario = 'Ativo'";

        List<Usuario> usuarios = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cargo cargo = CargoDAO.buscarCargoPorId(rs.getInt("id_cargo"));
                Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(rs.getInt("id_departamento"));

                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("CPF"),
                        rs.getString("nomeCompleto"),
                        rs.getString("email"),

                        rs.getDate("dataNascimento").toLocalDate(),
                        cargo,
                        departamento,
                        rs.getDouble("salario"),
                        rs.getDate("dataAdmissao").toLocalDate(),
                        TipoUsuario.valueOf(rs.getString("tipoUsuario")),
                        StatusUsuario.valueOf(rs.getString("statusUsuario")),

                        rs.getString("senha")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public static Usuario buscarUsuarioPorId(int id) throws SQLException {
        String comando = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(comando)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Cargo cargo = CargoDAO.buscarCargoPorId(rs.getInt("id_cargo"));
                Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(rs.getInt("id_departamento"));

                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("CPF"),
                        rs.getString("nomeCompleto"),
                        rs.getString("email"),

                        rs.getDate("dataNascimento").toLocalDate(),
                        cargo,
                        departamento,
                        rs.getDouble("salario"),
                        rs.getDate("dataAdmissao").toLocalDate(),
                        TipoUsuario.valueOf(rs.getString("tipoUsuario")),
                        StatusUsuario.valueOf(rs.getString("statusUsuario")),

                        rs.getString("senha")
                );
            }
        }
        return usuario;
    }


}

