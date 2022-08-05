package com.example.demo.controller;

import com.example.demo.entities.Odontologo;
import com.example.demo.entities.Paciente;
import com.example.demo.entities.Turno;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.OdontologoService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//hacerle responseEntity a to do
@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @PostMapping
    public ResponseEntity<String> guardarTurno(@RequestBody Turno turno)throws BadRequestException {
        turnoService.guardar((turno));
        return ResponseEntity.ok("se guardo correctamente el turno");
    }
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PutMapping
    public Turno actualizar(@RequestBody Turno turno){
        return turnoService.actualizar(turno);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id){
        if (turnoService.buscar(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscar(id).get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id)throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok("se elimino el turno corectamente");
    }
}
