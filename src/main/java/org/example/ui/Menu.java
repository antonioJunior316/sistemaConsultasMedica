package org.example.ui;

import java.util.Scanner;

import org.example.modelo.Consulta;
import org.example.modelo.Medico;
import org.example.modelo.Paciente;
import org.example.repository.BancoDeDados;
import org.example.servico.ConsultaService;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private ConsultaService consultaService = new ConsultaService();

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CONSULTAS =====");
            System.out.println("1 - Agendar consulta");
            System.out.println("2 - Listar consultas");
             System.out.println("3 - Reagendar consulta pelo id");
            System.out.println("4 - Cancelar consulta");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                case 1:
                    agendarConsulta();
                    break;

                case 2:
                    consultaService.listaConsultas();
                    break;

                case 3:
                    reagendarConsulta();
                    break;

                case 4:
                    cancelarConsulta();
                    break;
                     

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    private void agendarConsulta() {

        System.out.print("Nome do paciente: ");
        String nomePaciente = sc.nextLine();

        System.out.print("CPF do paciente: ");
        String cpfPaciente = sc.nextLine();

        System.out.print("Telefone do paciente: ");
        String telefone = sc.nextLine();

        Paciente paciente =
                new Paciente(nomePaciente, cpfPaciente, telefone);

        BancoDeDados.pacientes.add(paciente);

        System.out.print("Nome do médico: ");
        String nomeMedico = sc.nextLine();

        System.out.print("CPF do médico: ");
        String cpfMedico = sc.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();

        Medico medico =
                new Medico(nomeMedico, cpfMedico, especialidade);

        BancoDeDados.medicos.add(medico);

        System.out.print("Data da consulta: ");
        String data = sc.nextLine();

        Consulta consulta =
                new Consulta(paciente, medico, data, "Pendente");

        consulta.agendamento();

        consultaService.adicionaConsulta(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    private void cancelarConsulta() {

        consultaService.listaConsultas();

        if (BancoDeDados.consultas.isEmpty()) {
            return;
        }

        System.out.print("Digite o número da consulta: ");
        int indice = Integer.parseInt(sc.nextLine());

        consultaService.cancelarConsulta(indice - 1);
    }

    private void reagendarConsulta() {

        consultaService.listaConsultas();

        if (BancoDeDados.consultas.isEmpty()) {
            return;
        }

        System.out.print("Digite o número da consulta: ");
        int indice = Integer.parseInt(sc.nextLine());

        System.out.print("Digite a nova data: ");
        String novaData = sc.nextLine();

        consultaService.reagendarConsulta(indice - 1, novaData);
    }
}