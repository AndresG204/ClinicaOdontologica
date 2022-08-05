package com.example.demo.service;

import com.example.demo.entities.Odontologo;
import com.example.demo.entities.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    @Test
    public void buscarPaciente() {
        Paciente paciente = pacienteService.guardar(new Paciente("sanin", "santiago", "sanin@gmail.com", "fds1234"));
        Optional<Paciente> pacienteBuscado = pacienteService.buscar(paciente.getId());
        Assertions.assertTrue(pacienteBuscado.isPresent());
    }
    @Test
    public void listarPacientes(){
        pacienteService.guardar(new Paciente("rincon","sergio","roncon@gmail.com","sr23456"));
        pacienteService.guardar(new Paciente("sanin", "santiago", "sanin@gmail.com", "fds1234"));
        List<Paciente> listaPacientes=pacienteService.listarPacientes();
        Assertions.assertTrue(listaPacientes.size()>=1);
    }
    @Test
    public void agregarPaciente(){
        Paciente paciente=pacienteService.guardar(new Paciente("sanin", "santiago", "sanin@gmail.com", "fds1234"));
        Assertions.assertTrue(paciente.getId()!=null);
    }
}