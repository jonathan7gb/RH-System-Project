package org.rhsystem.controller;

import org.rhsystem.service.CargoService;
import org.rhsystem.view.CargoView;
import org.rhsystem.view.MessagesHelper;

public class CargoController {

    public static void cargoController() {
        do{
            int opcao = CargoView.menuCargo();

            switch (opcao){
                case 1 -> CargoService.registrarCargo();
                case 2 -> CargoService.editarCargo();
                case 3 -> CargoService.listarCargos();
                case 4 -> CargoService.buscarCargo();
                case 0 -> { return; }
                default -> MessagesHelper.error("Opção inválida!");
            }
        }while(true);
    }
}
