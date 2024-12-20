package br.edu.ifrs.riogrande.tads.ppa.ligaa;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Matricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Matricula.Situacao;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.MatriculaJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaJpaRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class LigaaApplication {

	@Autowired
	private AlunoJpaRepository alunoJpaRepository;

	@Autowired
	private MatriculaJpaRepository matriculaJpaRepository;

	@Autowired
	private ProfessorJpaRepository professorJpaRepository;

	@Autowired
	private DisciplinaJpaRepository disciplinaJpaRepository;

	@Autowired
	private TurmaJpaRepository turmaJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LigaaApplication.class, args); 
	}

	@PostConstruct
	void seed() {
		System.out.println("Semeando ... a discórdia!");

		// Criando o aluno
		System.out.println("Semeando ... a discórdia!");
		var can = new Aluno();
        can.setCpf("11122233344");
        can.setDataHoraCriacao(LocalDateTime.now());
        can.setDataHoraAlteracao(LocalDateTime.now());
        can.setDesativado(false);
        can.setEnderecoEletronico("can.robert@gmail.com");
		can.setLogin(can.getEnderecoEletronico());
        can.setNome("Canrobert Junior");
        can.setId(UUID.randomUUID());
		alunoJpaRepository.save(can); // Salva o aluno

		// Criando o professor
		var prof = new Professor();
		prof.setNome("Márcio");
		prof.setFormacao("Análise e Desenvolvimento de Sistemas"); 
		prof.setSiape("5022024");
		prof.setDesativado(false);
		prof.setId(UUID.randomUUID());
		professorJpaRepository.save(prof); // Salva o professor

		// Criando a disciplina
		var ppa20242 = new Disciplina();
		ppa20242.setCodigo("RGD-PPA005");
		ppa20242.setNome("PPA");
		ppa20242.setCargaHoraria(66);
		ppa20242.setAulasSemanais(4);
		disciplinaJpaRepository.save(ppa20242); // Salva a disciplina

		// Criando a turma
		var turma = new Turma();
		turma.setCodigo("2024-2");
		turma.setSala("Lab 7");
		turma.setVagas(30);
		turma.setFechada(false);
		turma.setDisciplina(ppa20242);
		turma.setProfessor(prof);
		turmaJpaRepository.save(turma); // Salva a turma

		// Criando a matrícula	
		var matricula = new Matricula();
		matricula.setId(UUID.randomUUID());
		matricula.setAluno(can);
		matricula.setSituacao(Situacao.REPROVADO);
		matriculaJpaRepository.save(matricula); // Salva a matrícula
		ppa20242.getMatriculas().add(matricula); // Adiciona a matrícula à disciplina

		// Adiciona a matrícula à turma
		turma.addMatricula(matricula);
		turmaJpaRepository.save(turma); // Salva a turma persistindo a matrícula

		System.out.println(ppa20242);





	}
}
