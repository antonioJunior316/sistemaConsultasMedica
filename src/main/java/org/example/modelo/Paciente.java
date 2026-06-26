package org.example.modelo;

public  class Paciente extends Pessoa {
    private String telefone;

    public Paciente(String nome,String cpf,String telefone){
        super(nome, cpf);
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }
}
