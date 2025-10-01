package org.rhsystem.view;

import org.rhsystem.model.Departamento;

import java.util.List;
import java.util.Scanner;

public class DepartamentoView {

    static Scanner input = new Scanner(System.in);

    public static int menuDepartamento(){
        System.out.println("\n|| ------- Departamento ------- ||");
        System.out.println("|| 1 - Cadastrar Departamento");
        System.out.println("|| 2 - Editar Departamento");
        System.out.println("|| 3 - Listar Departamentos");
        System.out.println("|| 4 - Buscar Departamento");
        System.out.println("|| 0 - Voltar ao Menu Principal");
        return InputHelper.inputInteger("Escolha uma opção: ", input);
    }

    public static Departamento cadastrarDepartamento(){
        System.out.println("\n|| ------- Cadastrar Departamento ------- ||");

        String nome = InputHelper.inputString("|| Nome do Departamento: ", input);
        String descricao = InputHelper.inputString("|| Descrição do Departamento: ", input);
        Departamento departamento = null;

        if(!nome.isBlank() && !descricao.isBlank()){
            departamento = new Departamento(nome, descricao);
        }
        return departamento;
    }

    public static Departamento editarDepartamento(Departamento departamento){
        System.out.println("\n|| ------- Editar Departamento ------- ||");

        String nome = InputHelper.inputString("|| Nome do Departamento (" + departamento.getNome() + ") (Enter para manter): ", input);
        String descricao = InputHelper.inputString("|| Descrição do Departamento (Enter para manter): ", input);

        if(!nome.isBlank()){
            departamento.setNome(nome);
        }
        if(!descricao.isBlank()){
            departamento.setDescricao(descricao);
        }

        return departamento;
    }

    public static void listarDepartamentos(List<Departamento> departamentos){
        System.out.println("\n|| ------- Listar Departamentos ------- ||\n");

        if(departamentos.isEmpty()){
            MessagesHelper.error("Nenhum departamento cadastrado.");
            return;
        }else {
            System.out.printf("|| %-3s || %-30s || %-80s ||\n", "ID", "NOME", "DESCRIÇÃO");
            for (Departamento departamento : departamentos) {
                System.out.printf("|| %-3d || %-30s || %-80s ||\n", departamento.getId(), departamento.getNome(), departamento.getDescricao());
            }
        }
    }

    public static int buscarDepartamento(){
        System.out.println("\n|| ------- Buscar Departamento ------- ||");

        return InputHelper.inputInteger("|| ID do Departamento: ", input);
    }
}
