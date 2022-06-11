package br.com.poo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name ="ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @OneToOne
    @JoinColumn(name ="ID_PESSOA")
    private Pessoa pessoa;

    @Column(name ="DATA_EMPRESTIMO")
    private Date DtEmprestimo = new Date();

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDtEmprestimo() {
        return DtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        DtEmprestimo = dtEmprestimo;
    }

}
