package model;

import java.util.Date;

public class Persona {

    private int codigopersona;
    private String nombre;
    private String apellido;
    private Date fecha;
    private String dni;
    private String telefono;
    private String ubigeo;
    private String dirreccion;
    private String tipo;
    private String estado;

    public void clear() {
        codigopersona=0;
        nombre = null;
        apellido = null;
        fecha = null;
        dni = null;
        telefono = null;
        tipo = null;
        ubigeo = null;
        dirreccion = null;
    }


    public int getCodigopersona() {
        return codigopersona;
    }

    public void setCodigopersona(int codigopersona) {
        this.codigopersona = codigopersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}