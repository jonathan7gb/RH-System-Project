package org.rhsystem.view;

import org.rhsystem.model.Departamento;

import java.util.List;
import java.util.Scanner;

public class DepartamentoView {

    static Scanner input = new Scanner(System.in);

    public static int menuDepartamento(){
        System.out.print("\n|| ------- Departamento ------- ||");

        System.out.println("1 - Cadastrar Departamento");
        System.out.println("2 - Editar Departamento");
        System.out.println("3 - Listar Departamentos");
        System.out.println("4 - Buscar Departamento");
        System.out.println("0 - Voltar ao Menu Principal");
        int opcao = InputHelper.inputInteger("Escolha uma opção: ", input);

        return opcao;
    }

    public static Departamento cadastrarDepartamento(){
        System.out.print("\n|| ------- Cadastrar Departamento ------- ||");

        String nome = InputHelper.inputString("Nome do Departamento: ", input);
        String descricao = InputHelper.inputString("Descrição do Departamento: ", input);

        Departamento departamento = new Departamento(nome, descricao);
        return departamento;
    }

    public static Departamento editarDepartamento(Departamento departamento){
        System.out.print("\n|| ------- Editar Departamento ------- ||");

        String nome = InputHelper.inputString("Nome do Departamento (" + departamento.getNome() + ") (Enter para manter): ", input);
        String descricao = InputHelper.inputString("Descrição do Departamento (Enter para manter): ", input);

        if(!nome.isBlank()){
            departamento.setNome(nome);
        }
        if(!descricao.isBlank()){
            departamento.setDescricao(descricao);
        }

        return departamento;
    }

    public static void listarDepartamentos(List<Departamento> departamentos){
        System.out.print("\n|| ------- Listar Departamentos ------- ||\n");

        System.out.printf("|| %-5s || %-20s || %-50s ||\n", "ID", "NOME", "DESCRIÇÃO");
        for (Departamento departamento : departamentos) {
            System.out.printf("|| %-5d || %-20s || %-50s ||\n", departamento.getId(), departamento.getNome(), departamento.getDescricao());
        }
    }

    public static int buscarDepartamento(){
        System.out.print("\n|| ------- Buscar Departamento ------- ||");

        int id = InputHelper.inputInteger("ID do Departamento: ", input);
        return id;
    }
}
