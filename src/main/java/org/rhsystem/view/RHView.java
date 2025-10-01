package org.rhsystem.view;
import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;
import org.rhsystem.model.HistoricoSaida;
import org.rhsystem.model.Usuario;
import org.rhsystem.model.enums.StatusUsuario;
import org.rhsystem.model.enums.TipoUsuario;
import org.rhsystem.model.validations.SenhaValidate;
import org.rhsystem.view.HistoricoSaidaView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class RHView {

    static Scanner input = new Scanner(System.in);

    public static int menuRH(){
        System.out.println("\n|| ---------- Usuário ---------- ||");
        System.out.println("|| 1 - Cadastrar usuário");
        System.out.println("|| 2 - Editar usuário");
        System.out.println("|| 3 - Inativar usuários");
        System.out.println("|| 4 - Listar usuários");
        System.out.println("|| 5 - Buscar usuários");
        System.out.println("|| 6 - Listar usuários inativos");
        System.out.println("|| 0 - Voltar ao Menu Principal");
        return InputHelper.inputInteger("Selecione uma opção: ", input);
    }

    public static Usuario cadastrarUsuario(){
        System.out.println("\n|| ---------- Cadastrar Usuário ---------- ||");
        String CPF = InputHelper.inputString("|| CPF do usuário: ", input);
        String nomeCompleto = InputHelper.inputString("|| Nome do usuário: ", input);
        String email = InputHelper.inputString("|| Email do usuário: ", input);
        LocalDate dataNascimento = InputHelper.inputDate("|| Data de nascimento do usuário: ", input);
        Cargo cargo = InputHelper.inputCargo("|| ID do cargo: ", input);
        Departamento departamento = InputHelper.inputDepartamento("|| ID do departamento: ", input);
        double salario = InputHelper.inputDouble("|| Salario do usuário: ", input);
        LocalDate dataAdmissao = InputHelper.inputDate("|| Data de admissao do usuário: ", input);
        TipoUsuario tipoUsuario = InputHelper.inputTipoUsuario("|| Tipo de Usuario: ", input);
        String senha = SenhaValidate.validarSenha("|| Digite a Senha: ");
        Usuario usuario = new Usuario(0,CPF, nomeCompleto, email, dataNascimento, cargo, departamento, salario, dataAdmissao, tipoUsuario, StatusUsuario.ATIVO, senha);

        return usuario;
    }

    public static Usuario editarUsuario( Usuario usuarioExistente){
        System.out.println("\n|| ---------- Editar Usuário ---------- ||");
        String CPF = InputHelper.inputString("|| CPF do usuário (" + usuarioExistente.getCPF() +") (Enter para manter): ", input);//possivel dor de cabeça, rever dps
        String nome = InputHelper.inputString("|| Nome do usuário (" + usuarioExistente.getNomeCompleto() + ") (Enter para manter): ", input);
        String email = InputHelper.inputString("|| Email do usuário (" + usuarioExistente.getEmail() + ") (Enter para manter): ", input);
        LocalDate dataNascimento = InputHelper.inputDateOptional("|| Data de nascimento do usuário (" + usuarioExistente.getDataNascimento() + ") (Enter para manter): ", usuarioExistente.getDataNascimento(), input);
        Cargo cargo = InputHelper.inputCargo("|| Cargo do usuário (" + usuarioExistente.getCargo() + "): ", input);
        Departamento departamento = InputHelper.inputDepartamento("|| Departamento do usuário (" + usuarioExistente.getDepartamento() + ") : ", input);
        double salario = InputHelper.inputDouble("|| Salário do usuário (" + usuarioExistente.getSalario() + "): ", input);
        LocalDate dataAdmissao = InputHelper.inputDateOptional("|| Data de admissão do usuário (" + usuarioExistente.getDataAdmissao() + ") (Enter para manter): ", usuarioExistente.getDataAdmissao(), input);
        TipoUsuario tipoUsuario = InputHelper.inputTipoUsuario("|| Tipo de usuário (" + usuarioExistente.getTipoUsuario() + "): ", input);
        String senha = InputHelper.inputString("|| Senha do usuário (Enter para manter): ", input);


        if(!CPF.isBlank()){
            usuarioExistente.setCPF(CPF);
        }
        if(!nome.isBlank()){
            usuarioExistente.setNomeCompleto(nome);
        }
        if(!email.isBlank()){
            usuarioExistente.setEmail(email);
        }
        usuarioExistente.setDataNascimento(dataNascimento);

        if(cargo != null){
            usuarioExistente.setCargo(cargo);
        }
        if(departamento != null){
            usuarioExistente.setDepartamento(departamento);
        }
        if(salario > 0){
            usuarioExistente.setSalario(salario);
        }
        usuarioExistente.setDataAdmissao(dataAdmissao);

        if(tipoUsuario != null){
            usuarioExistente.setTipoUsuario(tipoUsuario);
        }
        if(!senha.isBlank()){
            usuarioExistente.setSenha(senha);
        }


        return usuarioExistente;


    }

    public static HistoricoSaida inativarUsuario(Usuario usuario) {
        System.out.println("\n|| ---------- Inativar Usuário ---------- ||");
        System.out.println("|| Usuário: " + usuario.getNomeCompleto());

        return HistoricoSaidaView.coletarDadosSaida(usuario);
    }

    public static void listarUsuario (List<Usuario> usuarios){
        System.out.println("\n|| ------- Listar usuários ------- ||\n");
        if(usuarios.isEmpty()) {
            MessagesHelper.error("Nenhum usuário cadastrado.");
            return;
        }else{
            for(Usuario usuario : usuarios){

                System.out.println("---------------------------------------------------------------");

                System.out.println("|| ID: "+ usuario.getId());
                System.out.println("|| Nome do colaborador: "+ usuario.getNomeCompleto());
                System.out.println("|| Cargo do colaborador: "+ usuario.getCargo().getNome());
                System.out.println("|| Departamento do colaborador: "+ usuario.getDepartamento().getNome());

                System.out.println("----------------------------------------------------------------");


            }
        }
    }

    public static int buscarUsuario(){
        System.out.println("\n|| ------- Buscar usuário ------- ||");
        return InputHelper.inputInteger("|| ID do usuário: ", input);
    }

    public static void listarUsuariosInativos (List<HistoricoSaida> historicoSaidas){
        System.out.println("\n|| ------- Listar usuários inátivos------- ||\n");
        if(historicoSaidas.isEmpty()) {
            MessagesHelper.error("Nenhum usuário inativo encontrado.");
            return;
        }else{
            for(HistoricoSaida historicoSaida : historicoSaidas){
                System.out.println("|| ID: "+ historicoSaida.getUsuarioId());
                System.out.println("|| Data de saída: "+ historicoSaida.getDataSaida());
                System.out.println("|| Motivo da saída do colaborador: "+ historicoSaida.getMotivo());
                System.out.println("----------------------------------------------------------------------");
            }
        }
    }






}









