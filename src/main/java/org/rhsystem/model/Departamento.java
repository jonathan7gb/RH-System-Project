package org.rhsystem.model;

public class Departamento {

    private int id;
    private String nome;
    private String descricao;

    public Departamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Departamento(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "|| " + nome + " || " + descricao + " ||";
    }
}
