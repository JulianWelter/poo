package br.com.poo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME_PESSOA")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Emprestimo> relatorioDeEmprestimo;

    public Pessoa() {
    }

    public Pessoa(Long i, String nome) {
        this.id =  i;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
