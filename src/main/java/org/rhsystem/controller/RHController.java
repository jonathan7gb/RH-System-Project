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
                    UsuarioController.usuarioController();
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
                case 4: {
                    RelatorioController.relatorioController();
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

