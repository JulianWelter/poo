package br.com.poo.models;

import javax.persistence.*;

@Entity(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CATEGORIA")
    private int idCategoria;

    @Column(name = "DESC_CATEGORIA")
    private String DescCategoria;

    public String getDescCategoria() {
        return DescCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        DescCategoria = descCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

}
