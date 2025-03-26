/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author melissaalfaromesen
 */
public class EntradaEvento {
    private static int contadorEntradas = 1;
    private String codigo;
    private Usuario usuario;
    private Evento evento;
    private boolean usada;
    
    public EntradaEvento(String codigo, Usuario usuario, Evento evento) {
        this.codigo = "TKT-" + String.format("%05d", contadorEntradas++);
        this.usuario = usuario;
        this.evento = evento;
        this.usada = false;
    }
    
    public String getCodigo() { 
        return codigo; 
    }
    public Usuario getUsuario() { 
        return usuario; 
    }
    public Evento getEvento(){ 
        return evento; 
    }
    public boolean isUsada() { 
        return usada; 
    }
    public void validarEntrada() { 
        this.usada = true; 
    }
}
