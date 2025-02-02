package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "disciplinas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Disciplina extends Entidade {

    @Column(nullable = false)
    private String codigo;
    private String nome;
    private String ementa;
    private int cargaHoraria;
    private int aulasSemanais;

    // private List<Disciplina> preRequisitos = new ArrayList<>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // public List<Disciplina> getPreRequisitos() {
    //     return preRequisitos;
    // }

    // public void setPreRequisitos(List<Disciplina> preRequisitos) {
    //     this.preRequisitos = preRequisitos;
    // }

    public int getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(int aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
    }

    @Override
    public String toString() {
        return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", ementa=" + ementa + ", cargaHoraria="
                + cargaHoraria + ", aulasSemanais=" + aulasSemanais + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Disciplina other = (Disciplina) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    
}
