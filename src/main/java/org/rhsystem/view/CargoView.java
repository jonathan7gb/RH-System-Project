package org.rhsystem.view;

import org.rhsystem.model.Cargo;

import java.util.List;
import java.util.Scanner;

public class CargoView {

    static Scanner input = new Scanner(System.in);

    public static int menuCargo(){
        System.out.print("\n|| ------- Cargo ------- ||");

        System.out.println("1 - Cadastrar Cargo");
        System.out.println("2 - Editar Cargo");
        System.out.println("3 - Listar Cargos");
        System.out.println("4 - Buscar Cargo");
        System.out.println("0 - Voltar ao Menu Principal");
        int opcao = InputHelper.inputInteger("Escolha uma opção: ", input);

        return opcao;
    }

    public static Cargo cadastrarCargo(){
        System.out.print("\n|| ------- Cadastrar Cargo ------- ||");

        String nome = InputHelper.inputString("Nome do Cargo: ", input);
        String descricao = InputHelper.inputString("Descrição do Cargo: ", input);

        Cargo cargo = null;

        if(!nome.isBlank() && !descricao.isBlank()){
            cargo = new Cargo(nome, descricao);
        }
        return cargo;
    }

    public static Cargo editarCargo(Cargo cargo){
        System.out.print("\n|| ------- Editar Cargo ------- ||");

        String nome = InputHelper.inputString("Nome do Cargo (" + cargo.getNome() + ") (Enter para manter): ", input);
        String descricao = InputHelper.inputString("Descrição do Cargo (Enter para manter): ", input);

        if(!nome.isBlank()){
            cargo.setNome(nome);
        }
        if(!descricao.isBlank()){
            cargo.setDescricao(descricao);
        }

        return cargo;
    }

    public static void listarCargos(List<Cargo> cargos){
        System.out.print("\n|| ------- Listar Cargos ------- ||\n");

        if(cargos.isEmpty()){
            MessagesHelper.error("Nenhum cargo cadastrado.");
            return;
        }else {

            System.out.printf("|| %-5s || %-20s || %-50s ||\n", "ID", "NOME", "DESCRIÇÃO");
            for (Cargo cargo : cargos) {
                System.out.printf("|| %-5d || %-20s || %-50s ||\n", cargo.getId(), cargo.getNome(), cargo.getDescricao());
            }
        }
    }

    public static int buscarCargo(){
        System.out.print("\n|| ------- Buscar Cargo ------- ||");

        int id = InputHelper.inputInteger("ID do Cargo: ", input);
        return id;
    }
}
