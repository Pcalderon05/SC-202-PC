/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.util.*;
import java.text.*;

/**
 *
 * @author melissaalfaromesen
 */
public class GestorReportes {
    public void generarReporteEventos(List<Evento> eventos) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + " Nombre: " + evento.getNombre() + " Fecha: " + sdf.format(evento.getFechaHora()) + " Ubicación: " + evento.getUbicacion() + " Capacidad: " + evento.getCapacidadMax() + " Tipo: " + evento.getTipo());
        }
    }
    public void reporteAsistentesPorEvento (Evento evento){
        System.out.println("Asistentes del evento " + evento.getNombre());
        for (EntradaEvento entradas : evento.getEntradasVendidas()){
            System.out.println(entradas.getUsuario().getNombre() + " - " + entradas.getCodigo());
        }

    }
        public void reporteVentas(Evento evento) {
        System.out.println("Ventas para el evento " + evento.getNombre() + ": " + evento.getEntradasVendidas().size());
    }
}

