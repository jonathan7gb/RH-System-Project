package org.rhsystem.controller;

import org.rhsystem.service.RelatorioService;
import org.rhsystem.view.MessagesHelper;
import org.rhsystem.view.RelatoriosView;

public class RelatorioController {

    public static void relatorioController(){
        do{
            int opcao = RelatoriosView.menuRrlatorios();

            switch (opcao){
                case 1 -> RelatorioService.totalUsuariosExistentes();
                case 2 -> RelatorioService.totalCargosExistentes();
                case 3 -> RelatorioService.totalDepartamentosExistentes();
                case 4 -> RelatorioService.qntdFuncPorDepart();
                case 0 -> {return;}
                default -> MessagesHelper.error("Opção inválida!");
            }
        }while(true);
    }
}
