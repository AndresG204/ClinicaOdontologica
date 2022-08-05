package com.example.demo.service;

import com.example.demo.entities.Domicilio;
import com.example.demo.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;

    public List<Domicilio> listarDomicilios(){
        return domicilioRepository.findAll();
    }
    public Domicilio guardar(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }
    public void eliminar(Long id){
        domicilioRepository.deleteById(id);
    }
    public Optional<Domicilio> buscar(Long id){
        return domicilioRepository.findById(id);
    }
    public Domicilio actualizar(Domicilio domicilio){
        if(buscar(domicilio.getId()).isPresent()){
            return domicilioRepository.save(domicilio);
        }else {
            return null;
        }
    }

}
