package org.rhsystem.model.enums;

public enum StatusUsuario {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    StatusUsuario(String descricao) {
        this.descricao = descricao;
    }
}
