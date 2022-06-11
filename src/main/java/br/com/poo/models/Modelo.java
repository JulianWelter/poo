package br.com.poo.models;

import javax.persistence.*;

@Entity
public class Modelo {

    @Id
    @Column(name = "ID_MODELO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idModelo;

    @Column(name = "DESC_MODELO")
    private String descModelo;
//    private Marca marca;

    public Modelo(){}

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescModelo() {
        return descModelo;
    }

    public void setDescModelo(String descModelo) {
        this.descModelo = descModelo;
    }

}
