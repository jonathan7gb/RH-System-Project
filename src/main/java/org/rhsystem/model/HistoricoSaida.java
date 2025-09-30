package org.rhsystem.model;

import java.time.LocalDate;

public class HistoricoSaida {

    private int id;
    private int usuarioId;
    private LocalDate dataSaida;
    private String motivo;
    private String observacoes;

    public HistoricoSaida(int id, int usuarioId, LocalDate dataSaida, String motivo, String observacoes) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dataSaida = dataSaida;
        this.motivo = motivo;
        this.observacoes = observacoes;
    }

    public HistoricoSaida(int usuarioId, LocalDate dataSaida, String motivo, String observacoes) {
        this.usuarioId = usuarioId;
        this.dataSaida = dataSaida;
        this.motivo = motivo;
        this.observacoes = observacoes;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "|| Usuário ID: " + usuarioId + " || Data: " + dataSaida +
                " || Motivo: " + motivo + " || Obs: " + observacoes + " ||";
    }
}