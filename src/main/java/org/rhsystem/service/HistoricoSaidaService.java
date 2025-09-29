package org.rhsystem.service;

import org.rhsystem.dao.HistoricoSaidaDAO;
import org.rhsystem.model.HistoricoSaida;

import java.sql.SQLException;

public class HistoricoSaidaService {

    public static void salvarHistorico(HistoricoSaida historico) throws SQLException {
        if (historico == null) {
            throw new IllegalArgumentException("Histórico não pode ser nulo");
        }
        if (historico.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("ID do usuário inválido");
        }

        if (historico.getDataSaida() == null) {
            throw new IllegalArgumentException("Data de saída é obrigatória");
        }

        if (historico.getMotivo() == null || historico.getMotivo().trim().isEmpty()) {
            throw new IllegalArgumentException("Motivo da saída é obrigatório");
        }
        HistoricoSaidaDAO.salvarHistorico(historico);
    }
}