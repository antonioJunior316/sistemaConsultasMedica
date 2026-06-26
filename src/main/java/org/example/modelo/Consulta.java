package org.example.modelo;

public class Consulta implements Agendavel{
    private Paciente paciente;
    private Medico medico;
    private String data;
    private String status;

    public Consulta(Paciente paciente,Medico medico, String data,String status){
        this.paciente = paciente;
        this.medico = medico;
        this.status = status;
        this.data = data;

    }

    public void alterarData(String novaData){
        this.data = novaData;
    }

    @Override
    public void agendamento(){
        this.status = "Agendada";
    }

    @Override
    public void cancelar(){
        this.status = "Cancelada";
    }

    @Override
    public String toString() {
        return "\n=====================================\n"+
               "Paciente: " + paciente.getNome() +"\n"+
               "Médico: " + medico.getNome() +"\n"+
               "Data: " + data +"\n"+
               "Status: " + status+"\n"+
               "=====================================\n\n";
    }

}
