package org.rhsystem.model;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;

import java.time.LocalDate;

public class Usuario {

    private int id;
    private String CPF;
    private String nomeCompleto;
    private String email;
    private LocalDate dataNascimento;
    private Cargo cargo;
    private Departamento departamento;
    private double salario;
    private LocalDate dataAdmissao;
    private TipoUsuario tipoUsuario;
    private StatusUsuario statusUsuario;
    private String senha;

    public Usuario(int id, String CPF, String nomeCompleto, String email, LocalDate dataNascimento, Cargo cargo, Departamento departamento, double salario, LocalDate dataAdmissao, TipoUsuario tipoUsuario, StatusUsuario statusUsuario, String senha) {
        this.id = id;
        this.CPF = CPF;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.tipoUsuario = tipoUsuario;
        this.statusUsuario = statusUsuario;
        this.senha = senha;
    }

    public Usuario(String CPF, String nomeCompleto, String email, LocalDate dataNascimento, Cargo cargo, Departamento departamento, double salario, LocalDate dataAdmissao, TipoUsuario tipoUsuario, String senha) {
        this.CPF = CPF;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.tipoUsuario = tipoUsuario;
        this.statusUsuario = StatusUsuario.ATIVO;
        this.senha = senha;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public StatusUsuario getStatusUsuario() { return statusUsuario;}

    public void setStatusUsuario (StatusUsuario statusUsuario){ this.statusUsuario = statusUsuario; }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "|| " + nomeCompleto + " || " + CPF + "|| " + dataNascimento + "\n|| " + email + " ||" + cargo.getNome() + " || " + departamento.getNome() + "|| " + salario + " ||";
    }
}
