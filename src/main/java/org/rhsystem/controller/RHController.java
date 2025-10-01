package org.rhsystem.controller;

import org.rhsystem.service.RHService;
import org.rhsystem.view.MenuPrincipalView;
import org.rhsystem.view.MessagesHelper;
import org.rhsystem.view.RHView;

public class RHController {

    public static void rhController(){
        do{
            int opcaoMenuPrincipal = MenuPrincipalView.menuPrincipal();

            switch (opcaoMenuPrincipal){
                case 1: {
                    int opcao = RHView.menuRH();

                    switch (opcao){
                        case 1 -> RHService.cadastrarUsuario();
                        case 2 -> RHService.editarUsuario();
                        case 3 -> RHService.inativarUsuario();
                        case 4 -> RHService.listarUsuario();
                        case 5 -> RHService.buscarUsuario();
                        case 6 -> RHService.listarUsuariosInativos();
                        case 0 -> { return; }
                        default -> MessagesHelper.error("Opção inválida!");
                    }
                    break;
                }
                case 2: {
                    CargoController.cargoController();
                    break;
                }
                case 3: {
                    DepartamentoController.departamentoController();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    MessagesHelper.invalidIntInput();
                    break;
                }
            }

        }while(true);
    }
}

