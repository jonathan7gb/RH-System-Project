package org.rhsystem.controller;

import org.rhsystem.model.Usuario;
import org.rhsystem.service.FuncionarioService;
import org.rhsystem.view.FuncionarioView;
import org.rhsystem.view.MessagesHelper;

public class FuncionarioController {

    public static void funcionarioController(Usuario usuario) {
        do {
            int opcao = FuncionarioView.menuFuncionario();
            switch (opcao) {

                case 1: {
                    FuncionarioView.visualizarInformacoes(usuario);
                    break;
                }

                case 2: {
                    FuncionarioService.visualizarColegasDepartamento(usuario);
                    break;
                }

                case 3: {
                    FuncionarioService.alterarSenha(usuario);
                    break;
                }

                case 0: {
                    return;
                }

                default: {
                    MessagesHelper.error("Opção inválida!");
                    break;
                }
            }

        }while (true);
    }
}
