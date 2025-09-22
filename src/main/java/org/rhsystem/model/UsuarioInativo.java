package org.rhsystem.model;

import java.time.LocalDate;

public class UsuarioInativo{

    private int id;
    private String CPF;
    private String nomeCompleto;
    private String email;
    private Cargo ultimoCargo;
    private Departamento ultimoDepartamento;
    private LocalDate dataAdmissao;
    private LocalDate dataSaida;
    private String motivoInativacao;

    public UsuarioInativo(int id, String CPF, String nomeCompleto, String email, Cargo ultimoCargo, Departamento ultimoDepartamento, LocalDate dataAdmissao, LocalDate dataSaida, String motivoInativacao) {
        this.id = id;
        this.CPF = CPF;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.ultimoCargo = ultimoCargo;
        this.ultimoDepartamento = ultimoDepartamento;
        this.dataAdmissao = dataAdmissao;
        this.dataSaida = dataSaida;
        this.motivoInativacao = motivoInativacao;
    }

    public UsuarioInativo(String CPF, String nomeCompleto, String email, Cargo ultimoCargo, Departamento ultimoDepartamento, LocalDate dataAdmissao, String motivoInativacao) {
        this.CPF = CPF;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.ultimoCargo = ultimoCargo;
        this.ultimoDepartamento = ultimoDepartamento;
        this.dataAdmissao = dataAdmissao;
        this.motivoInativacao = motivoInativacao;
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

    public Cargo getUltimoCargo() {
        return ultimoCargo;
    }

    public void setUltimoCargo(Cargo ultimoCargo) {
        this.ultimoCargo = ultimoCargo;
    }

    public Departamento getUltimoDepartamento() {
        return ultimoDepartamento;
    }

    public void setUltimoDepartamento(Departamento ultimoDepartamento) {
        this.ultimoDepartamento = ultimoDepartamento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getMotivoInativacao() {
        return motivoInativacao;
    }

    public void setMotivoInativacao(String motivoInativacao) {
        this.motivoInativacao = motivoInativacao;
    }

    @Override
    public String toString(){
        return "|| " + nomeCompleto + " || " + CPF + "|| " + email + "\n|| " + ultimoDepartamento.getNome() + "|| " + ultimoCargo.getNome() + "\n|| Motivo: " + motivoInativacao + "\n|| Data de Saída: " + dataSaida + " ||";
    }
}
