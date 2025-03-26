/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author melissaalfaromesen
 */

class ControlAcceso {
    private List<Evento> eventos;
    private List<Usuario> usuarios;
    
    public ControlAcceso() {
        this.eventos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    
    public void registrarEvento(Evento evento) {
        if (eventos.size() < 50) {
            eventos.add(evento);
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más eventos (máximo 50).");
        }
    }
    
    public void registrarUsuario(Usuario usuario) {
        if (usuarios.size() < 200) {
            usuarios.add(usuario);
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios (máximo 200).");
        }
    }
    
public Evento buscarEvento(String id) {
    for (Evento evento : eventos) {
        if (evento.getId().equals(id)){
            return evento;
            }
    }
    return null;
}

    public Usuario buscarUsuario(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }
    
    public List<Evento> getEventos() {
        return eventos;
    }
}

