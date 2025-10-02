package org.rhsystem.model.enums;

public enum TipoUsuario {
    RH("RH"),
    FUNCIONARIO("Funcionario");

    private final String descricao;


    public String getDescricao() {
        return descricao;
    }

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
}
