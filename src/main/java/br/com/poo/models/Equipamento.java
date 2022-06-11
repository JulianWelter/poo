package br.com.poo.models;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(name = "status")
    private String status;

    @Id
    @Column(name = "ID_EQUIPAMENTO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEquipamento;

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

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Boolean estaEmprestado(){
        return Objects.equals(this.status, "indisponivel");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
