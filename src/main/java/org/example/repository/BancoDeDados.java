package org.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.modelo.Consulta;
import org.example.modelo.Medico;
import org.example.modelo.Paciente;

public class BancoDeDados {
    public static List<Paciente> pacientes = new ArrayList<>();
    public static List<Medico> medicos = new ArrayList<>();
    public static List<Consulta> consultas = new ArrayList<>();
}
