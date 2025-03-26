/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.*;
/**
 *
 * @author melissaalfaromesen
 */
public class EventosGo {
    public static void main(String[] args) {
        ControlAcceso control = new ControlAcceso();
        GestorReportes reportes = new GestorReportes();
        
        int opcion;
        do {
            String input = JOptionPane.showInputDialog("Seleccione una opción:\n1. Registrar Evento\n2. Registrar Usuario\n3. Comprar Entrada\n4. Ver Reporte de Eventos\n5. Salir");
            if (input == null) 
                break;
            opcion = Integer.parseInt(input);
            if (opcion == 1) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
                String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del evento:");
                String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha y hora del evento (formato: dd/MM/yyyy HH:mm):");
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date fecha = format.parse(fechaStr);
                    int capacidadMax = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad máxima del evento:"));
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de evento (Concierto, Fiesta, etc.):");
                    Evento evento = new Evento(nombre, ubicacion, fecha, capacidadMax, tipo);
                    control.registrarEvento(evento);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto.");
                }
            } else 
                if (opcion == 2) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                String identificacion = JOptionPane.showInputDialog("Ingrese el número de identificación:");
                String correo = JOptionPane.showInputDialog("Ingrese el correo del usuario:");
                
                // Pedir el rol al usuario
                String[] opcionesRol = { "ADMIN", "USUARIO", "INVITADO" };
                String seleccionRol = (String) JOptionPane.showInputDialog(null, "Seleccione el rol del usuario:", "Rol",
                JOptionPane.QUESTION_MESSAGE, null, opcionesRol, opcionesRol[1]);

                  // Convertir el texto a un enum Rol
                Rol rol = Rol.valueOf(seleccionRol); // Convierte el texto seleccionado a un enum

                //crear usuario con rol
                Usuario usuario = new Usuario(nombre, identificacion, correo, rol);
                control.registrarUsuario(usuario);
            } else 
                    if (opcion == 3) {
                String correoUsuario = JOptionPane.showInputDialog("Ingrese el correo del usuario:");
                Usuario usuario = control.buscarUsuario(correoUsuario);
                if (usuario != null) {
                    String idEvento = JOptionPane.showInputDialog("Ingrese el ID del evento:");
                    Evento evento = control.buscarEvento(idEvento);
                    if (evento != null && evento.getEntradasVendidas().size() < evento.getCapacidadMax()) {
                        EntradaEvento entrada = new EntradaEvento(usuario, evento);
                        evento.getEntradasVendidas().add(entrada);
                        JOptionPane.showMessageDialog(null, "Entrada comprada con éxito! Código: " + entrada.getCodigo());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay disponibilidad de entradas o evento no encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no registrado.");
                }
            } else 
                        if (opcion == 4) {
                String reporte = JOptionPane.showInputDialog("Seleccione reporte:\n1. Reporte de Eventos\n2. Reporte de Asistentes\n3. Reporte de Ventas");
                if (reporte != null) {
                    if (reporte.equals("1")) {
                        reportes.generarReporteEventos(control.getEventos());
                    } else 
                        if (reporte.equals("2")) {
                        String idEvento = JOptionPane.showInputDialog("Ingrese el ID del evento:");
                        Evento evento = control.buscarEvento(idEvento);
                        if (evento != null) {
                            reportes.reporteAsistentesPorEvento(evento);
                        } else {
                            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
                        }
                    } else 
                        if (reporte.equals("3")) {
                        String idEvento = JOptionPane.showInputDialog("Ingrese el ID del evento:");
                        Evento evento = control.buscarEvento(idEvento);
                        if (evento != null) {
                            reportes.reporteVentas(evento);
                        } else {
                            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
                        }
                    }
                }
            }
        } while (opcion != 5);
    }
}

