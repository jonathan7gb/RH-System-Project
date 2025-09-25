package org.rhsystem.controller;

import org.rhsystem.service.DepartamentoService;
import org.rhsystem.view.DepartamentoView;
import org.rhsystem.view.MessagesHelper;

public class DepartamentoController {

    public static void departamentoController() {
        do{
            int opcao = DepartamentoView.menuDepartamento();

            switch (opcao){
                case 1 -> DepartamentoService.registrarDepartamento();
                case 2 -> DepartamentoService.editarDepartamento();
                case 3 -> DepartamentoService.listarDepartamentos();
                case 4 -> DepartamentoService.buscarDepartamento();
                case 0 -> { return; }
                default -> MessagesHelper.error("Opção inválida!");
            }
        }while(true);
    }
}
