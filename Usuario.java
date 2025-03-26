/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author melissaalfaromesen
 */
//Enum para los roles de usuario
    enum Rol {
    ADMIN, USUARIO, INVITADO;
}


public class Usuario {
    private static int contadorUsuarios = 1;
    private String id;
    private String nombre;
    private String identificacion;
    private String correo;
    private Rol rol;//definir el tipo de usuario
    
    public Usuario(int id, String nombre, String identificacion, String correo, Rol rol) {
        this.id = "USR-" + contadorUsuarios;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.rol= rol;//asignamos el rol al usuario
    }
    
    public String getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getIdentificacion() { 
        return identificacion; 
    }
    public String getCorreo() { 
        return correo; 
    }
    public Rol getRol(){
        return rol;
    }
}

