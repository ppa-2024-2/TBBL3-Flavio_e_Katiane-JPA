package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_matriculas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Matricula extends Entidade {
   
    public enum Situacao {
        REGULAR,
        APROVEITAMENTO,
        CANCELADO,
        APROVADO,
        REPROVADO
    }
    @Column(nullable = false)
    private int numero;

    @ManyToAny
    private Aluno aluno;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Matricula [numero=" + numero + ", aluno=" + aluno + ", situacao=" + situacao + "]";
    }

    
}
