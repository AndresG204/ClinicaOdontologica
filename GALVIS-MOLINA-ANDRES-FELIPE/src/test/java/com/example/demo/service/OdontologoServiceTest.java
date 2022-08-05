package com.example.demo.service;

import com.example.demo.entities.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;


    @Test
    public void listarOdontologos(){
        odontologoService.guardar(new Odontologo("sergio","rincon","sr7895"));
        odontologoService.guardar(new Odontologo("santiago","sanin","sn128"));
        List<Odontologo> listaOdontologos=odontologoService.listarOdontologos();
        Assertions.assertTrue(listaOdontologos.size()>=1);
    }
    @Test
    public void buscarOdontologo(){
        Odontologo odontologo=odontologoService.guardar(new Odontologo("santiago","sanin","sn128"));
        Optional<Odontologo> odontologoBuscado=odontologoService.buscar(odontologo.getId());
        Assertions.assertTrue(odontologoBuscado.isPresent());

    }
    @Test
    public void agregarOdontologo(){
        Odontologo odontologo=odontologoService.guardar(new Odontologo("santiago","sanin","sn128"));
        Assertions.assertTrue(odontologo.getId()!=null);
    }


}