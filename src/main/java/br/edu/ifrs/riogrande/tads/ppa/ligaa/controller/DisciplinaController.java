package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.DisciplinaService;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovaDisciplina;



public class DisciplinaController { 

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    //
    @PostMapping(path = "api/v1/disciplinas")
    public List<Disciplina> getDisciplinas() {
        return disciplinaService.getDisciplinas();
    }

    @GetMapping(path = "api/v1/disciplinas")
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaService.getDisciplinas();
    }


    // @GetMapping(path = "/api/v1/disciplinas")
    // public ResponseEntity<Iterable<Disciplina>> buscaTodos() {
    //     return ResponseEntity.ok(disciplinaService.findAll()); // Outras opções: 404 ou 204
    // }

    
}