package org.rhsystem.view;

import org.rhsystem.model.HistoricoSaida;
import org.rhsystem.model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class HistoricoSaidaView {

    static Scanner input = new Scanner(System.in);


    public static HistoricoSaida coletarDadosSaida(Usuario usuario) {
        System.out.println("\n|| ---------- Registrar Saída ---------- ||");
        System.out.println("|| Usuário: " + usuario.getNomeCompleto());

        String confirmacao = InputHelper.inputString("|| Confirmar inativação? (s/n): ", input);

        if (!confirmacao.toLowerCase().equals("s")) {
            System.out.println("|| Atividade cancelada! ||");
            return null;
        }

        LocalDate dataSaida = InputHelper.inputDate("|| Data de saída: ", input);
        String motivo = InputHelper.inputString("|| Motivo da saída: ", input);
        String observacoes = InputHelper.inputString("|| Observações (opcional): ", input);

        return new HistoricoSaida(usuario.getId(), dataSaida, motivo, observacoes);
    }
}