package br.com.poo.models;

import javax.persistence.*;

@Entity
public class Equipamento {

    @OneToOne
    @JoinColumn(name = "ID_MARCA")
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "ID_MODELO")
    private Modelo modelo;

    @OneToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    @Id
    @Column(name = "ID_EQUIPAMENTO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private float idEquipamento;

    public Equipamento() {
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(float idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

}
