package br.com.poo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_PESSOA")
    private Aluno pessoa;

    @Column(name ="DATA_EMPRESTIMO")
    private Date DtEmprestimo;

    public Emprestimo() {
    }

    public Date getDtEmprestimo() {
        return DtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        DtEmprestimo = dtEmprestimo;
    }

}
