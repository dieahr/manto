package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


public class Expedicion extends ClaseBase
        implements Serializable {
    
    private Long id;
    private String nombre;
    private String descripcion;
    private String cantidad;
    private String lugarencuentro;
    private String estado;
    private String pais;
    private String direccion;
    private String fecha;
    private String hora;

    public Expedicion() {
    }

    public Expedicion(Long id){
        this.id = id;
    }

    public Expedicion(String nombre, String descripcion,String cantidad,String lugarencuentro,String estado, String fecha, String pais, String direccion, String hora){
        this.nombre=nombre;
        this.descripcion=descripcion;
	this.cantidad=cantidad;
	this.lugarencuentro=lugarencuentro;
	this.estado=estado;
        this.pais = pais;
        this.direccion = direccion;
        this.fecha=fecha;
        this.hora = hora;
    }

    /**
     * Regresa el id de la Expedicion.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id de la Expedicion.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre de la Expedicion.
     * @return String
     * @return 
     */
    public String getNombre() {
        return this.nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getCantidad() {
        return this.cantidad;
    }
    public String getLugarEncuentro() {
        return this.lugarencuentro;
    }
    public String getEstado() {
        return this.estado;
    }
    public String getPais() {
        return this.pais;
    }
    public String getDireccion() {
        return this.direccion;
    }     
    public String getFecha() {
        return this.fecha;
    }
    public String getHora(){
        return this.hora;
    }
    /**
     * Establece el nombre de la expedici?n.
     * @param nombre
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public void setLugarEncuentro(String lugarencuentro) {
        this.lugarencuentro = lugarencuentro;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void serHora(String hora){
        this.hora = hora;
    }
    /**
     * Regresa la descripción del Hotel.
     * @return String
     */


    /**
     * Establece la descripción del Hotel.
     * @return void
     */

}
