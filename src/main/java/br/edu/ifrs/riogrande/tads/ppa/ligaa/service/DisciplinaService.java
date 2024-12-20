package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaJpaRepository;

@Service
public class DisciplinaService {
    private final DisciplinaJpaRepository disciplinaRepository;

    public List<Disciplina> getDisciplinas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDisciplinas'");
    }

    public Object findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
