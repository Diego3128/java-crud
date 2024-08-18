package com.diegoperez.apirest.crudapirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private double calorias;
    private double grasas;
    private double carbohidratos;
    private double proteina;
    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    public double getGrasas() {
        return grasas;
    }
    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }
    public double getCarbohidratos() {
        return carbohidratos;
    }
    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public double getProteina() {
        return proteina;
    }
    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

}
