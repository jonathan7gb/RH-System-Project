package org.rhsystem.view;

import org.rhsystem.dao.CargoDAO;
import org.rhsystem.dao.DepartamentoDAO;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;
import org.rhsystem.model.HistoricoSaida;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InputHelper {

    //MÉTODO PARA LER E VALIDAR NÚMEROS INTEIROS
    public static int inputInteger(String mensagem, Scanner sc) {
        int leitura = -1;
        do {
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try {
                leitura = Integer.parseInt(leituraStr);
                break;
            } catch (NumberFormatException e) {
                MessagesHelper.invalidIntInput();
                continue;
            }
        } while (true);
        return leitura;
    }

    //=============================================================================

    //MÉTODO PARA LER E VALIDAR NÚMEROS DECIMAIS
    public static double inputDouble(String mensagem, Scanner sc) {

        double leitura = -1;
        do {
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try {
                leitura = Double.parseDouble(leituraStr);
                break;
            } catch (NumberFormatException e) {
                MessagesHelper.invalidDoubleInput();
                continue;
            }
        } while (true);
        return leitura;
    }

    //=============================================================================

    //MÉTODO PARA E VALIDAR LER STRINGS
    public static String inputString(String mensagem, Scanner sc) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    //=============================================================================

    public static LocalDate inputDate(String mensagem, Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine();

            try {
                LocalDate data = LocalDate.parse(input, formatter);

                int ano = data.getYear();
                if (ano < 1900 || ano > 2026) {
                    MessagesHelper.error("Ano inválido. Deve estar entre 1900 e 2026.");
                    continue;
                }

                return data;

            } catch (DateTimeParseException e) {
                MessagesHelper.error("Data inválida. Use o formato dd/MM/yyyy.");
            }
        }
    }

    //=============================================================================
    public static LocalDate inputDateOptional(String mensagem, LocalDate valorAtual, Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return valorAtual;
            }

            try {
                LocalDate data = LocalDate.parse(input, formatter);

                int ano = data.getYear();
                if (ano < 1900 || ano > 2026) {
                    MessagesHelper.error("Ano inválido. Deve estar entre 1900 e 2026.");
                    continue;
                }

                return data;

            } catch (DateTimeParseException e) {
                MessagesHelper.error("Data inválida. Use o formato dd/MM/yyyy ou Enter para manter.");
            }
        }
    }

    //meu
    //===============================================================================
    //MÉTODO PARA SELECIONAR CARGO
    public static Cargo inputCargo(String mensagem, Scanner sc) {
        while (true) {
            try {
                // Listar cargos disponíveis
                List<Cargo> cargos = CargoDAO.listarCargos();

                if (cargos.isEmpty()) {
                    MessagesHelper.error("Nenhum cargo cadastrado. Cadastre um cargo primeiro.");
                    return null;
                }

                // Usar o método da CargoView para mostrar os cargos
                CargoView.listarCargos(cargos);

                int cargoId = inputInteger(mensagem, sc);

                // Buscar cargo por ID
                Cargo cargo = CargoDAO.buscarCargoPorId(cargoId);

                if (cargo != null) {
                    return cargo;
                } else {
                    MessagesHelper.error("Cargo não encontrado. Tente novamente.");
                }
            } catch (SQLException e) {
                MessagesHelper.error("Erro ao buscar cargos: " + e.getMessage());
            }
        }
    }

    //MÉTODO PARA SELECIONAR DEPARTAMENTO
    public static Departamento inputDepartamento(String mensagem, Scanner sc) {
        while (true) {
            try {
                // Listar departamentos disponíveis
                List<Departamento> departamentos = DepartamentoDAO.listarDepartamentos();

                if (departamentos.isEmpty()) {
                    MessagesHelper.error("Nenhum departamento cadastrado. Cadastre um departamento primeiro.");
                    return null;
                }

                // Usar o método da DepartamentoView para mostrar os departamentos
                DepartamentoView.listarDepartamentos(departamentos);

                int departamentoId = inputInteger(mensagem, sc);

                Departamento departamento = DepartamentoDAO.buscarDepartamentoPorId(departamentoId);

                if (departamento != null) {
                    return departamento;
                } else {
                    MessagesHelper.error("Departamento não encontrado. Tente novamente.");
                }
            } catch (SQLException e) {
                MessagesHelper.error("Erro ao buscar departamentos: " + e.getMessage());
            }
        }
    }

    //MÉTODO PARA SELECIONAR TIPO DE USUÁRIO
    public static TipoUsuario inputTipoUsuario(String mensagem, Scanner sc) {
        while (true) {
            System.out.println("|| Tipos de usuário disponíveis:");
            System.out.println("|| 0 - " + TipoUsuario.RH.name());
            System.out.println("|| 1 - " + TipoUsuario.FUNCIONARIO.name());

            int opcao = inputInteger(mensagem, sc);

            if (opcao == 0) {
                return TipoUsuario.RH;
            } else if (opcao == 1) {
                return TipoUsuario.FUNCIONARIO;
            } else {
                MessagesHelper.error("Opção inválida. Digite 0 ou 1.");
            }
        }
    }

//===========================================================================


    //Adicione no InputHelper
    public static StatusUsuario inputStatusUsuario(String mensagem, Scanner sc) {
        while (true) {
            System.out.println("|| Status de usuário disponíveis:");
            System.out.println("|| 0 - " + StatusUsuario.ATIVO.getDescricao());
            System.out.println("|| 1 - " + StatusUsuario.INATIVO.getDescricao());

            int opcao = inputInteger(mensagem, sc);

            if (opcao == 0) {
                return StatusUsuario.ATIVO;
            } else if (opcao == 1) {
                return StatusUsuario.INATIVO;
            } else {
                MessagesHelper.error("Opção inválida. Digite 0 ou 1.");
            }
        }
    }
}