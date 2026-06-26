package org.example.servico;

import org.example.modelo.Consulta;
import org.example.repository.BancoDeDados;

public class ConsultaService {
    public void adicionaConsulta (Consulta consulta){
        BancoDeDados.consultas.add(consulta);
    }

    public void listaConsultas(){
        if(BancoDeDados.consultas.isEmpty()){
            System.out.println(
            "\n====================================\nNenhuma consulta cadastrada\n====================================\n");
            return;
        }
        for(int i = 0; i < BancoDeDados.consultas.size();i++){
            System.out.println("\n=====================================\n" +
                                "id da consulta : "+(i+1)+
            BancoDeDados.consultas.get(i)
            );
        }
    }

    public void cancelarConsulta(int indice) {

        if (indice >= 0 &&
            indice < BancoDeDados.consultas.size()) {

            BancoDeDados.consultas.get(indice).cancelar();
            System.out.println("Consulta cancelada.");
        }
    }

    public void reagendarConsulta(int indice, String novaData) {

        if (indice >= 0 &&
            indice < BancoDeDados.consultas.size()) {

            BancoDeDados.consultas.get(indice)
                                .alterarData(novaData);

            System.out.println("Consulta reagendada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}