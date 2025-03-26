/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author melissaalfaromesen
 */
public class Evento {
    private static int contadorEventos = 1;
    private String id;
    private String nombre;
    private String ubicacion;
    private Date fechaHora;
    private int capacidadMax;
    private String tipo;
    private List<EntradaEvento> entradasVendidas;
    
    public Evento(String nombre, String ubicacion, Date fechaHora, int capacidadMax, String tipo) {
        this.id = "EVT-" + String.format("%05d", contadorEventos++);
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.capacidadMax = capacidadMax;
        this.tipo = tipo;
        this.entradasVendidas = new ArrayList<>();
    }
    
    public String getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getUbicacion() { 
        return ubicacion; 
    }
    public Date getFechaHora() { 
        return fechaHora; 
    }
    public int getCapacidadMax() { 
        return capacidadMax; 
    }
    public String getTipo() { 
        return tipo; 
    }
    public List<EntradaEvento> getEntradasVendidas() { 
        return entradasVendidas; 
    }
}
