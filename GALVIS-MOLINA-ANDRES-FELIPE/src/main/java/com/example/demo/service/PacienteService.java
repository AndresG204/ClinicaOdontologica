package com.example.demo.service;

import com.example.demo.entities.Paciente;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }
    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public Optional<Paciente> buscar(Long id){
        return pacienteRepository.findById(id);
    }
    public Paciente actualizar(Paciente paciente){
        if (buscar(paciente.getId()).isPresent()){
            return pacienteRepository.save(paciente);
        }else {
            return null;
        }
    }
    public void eliminar (Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteBuscado = buscar(id);
        if (pacienteBuscado.isPresent()){
            pacienteRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("no existe el paciente con el id: "+id+" ingrese un id valido");
        }
    }
}
