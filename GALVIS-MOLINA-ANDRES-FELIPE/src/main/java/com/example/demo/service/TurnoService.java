package com.example.demo.service;

import com.example.demo.entities.Odontologo;
import com.example.demo.entities.Paciente;
import com.example.demo.entities.Turno;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.TurnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoService {
    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;

    public void guardar (Turno turno)throws BadRequestException {
        Optional<Paciente> paciente= pacienteService.buscar(turno.getPaciente().getId());
        Optional<Odontologo> odontologo= odontologoService.buscar(turno.getOdontologo().getId());
        if (paciente.isPresent()&&odontologo.isPresent()){
               turnoRepository.save(turno);
        }else {

              throw new BadRequestException("el paciente o el odontologo no existe, por lo tanto no puede guardar un turno");
        }

    }
    public List<Turno> listarTurnos(){

        return turnoRepository.findAll();
    }
    public Optional<Turno> buscar(Long id){
        return turnoRepository.findById(id);
    }
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado=buscar(id);
        if (turnoBuscado.isPresent()){
            turnoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe un turno con el id: "+id+" ingrese un id valido");
        }
    }
    public Turno actualizar(Turno turno){
        if (buscar(turno.getId()).isPresent()){
            return turnoRepository.save(turno);
        }else {
            return null;
        }
    }
}
