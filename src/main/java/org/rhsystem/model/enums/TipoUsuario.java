package org.rhsystem.model.enums;

public enum TipoUsuario {
    ADMIN("Admin"),
    FUNCIONARIO("Funcionário");

    private final String descricao;


    public String getDescricao() {
        return descricao;
    }

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
}
