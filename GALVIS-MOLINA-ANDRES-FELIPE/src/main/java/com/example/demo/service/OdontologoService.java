package com.example.demo.service;

import com.example.demo.entities.Odontologo;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;

    public List<Odontologo> listarOdontologos(){
        return odontologoRepository.findAll();
    }
    public Optional<Odontologo> buscar(Long id){
        return odontologoRepository.findById(id);
    }
    //hacer lo de las excepciones con todos los que puedan arrojar una exepcion de no encontrado
    public void borrar(Long id)throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado=buscar(id);
        if (odontologoBuscado.isPresent()){
            odontologoRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No existe nungun odontologo con el id:"+id+"; ingrese un id valido");
        }
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public Odontologo actualizar (Odontologo odontologo){
        if (buscar(odontologo.getId()).isPresent()){
            return odontologoRepository.save(odontologo);
        }else {
            return null;
        }
    }
}
