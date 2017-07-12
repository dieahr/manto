package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *
 *
 * <p><a href="Critica.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Resena extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
	private String estado;
	private String puntuacion;

    public Resena() {
    }

    public Resena(Long id){
        this.id = id;
    }

    public Resena(String nombre, String descripcion,String estado,String puntuacion){
        this.nombre=nombre;
        this.descripcion=descripcion;
		this.estado=estado;
		this.puntuacion=puntuacion;
    }

    /**
     * Regresa el id del Critica.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Critica.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Critica.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
	public String getDescripcion() {
        return this.descripcion;
    }
	public String getEstado() {
        return this.estado;
    }
	public String getPuntuacion() {
        return this.puntuacion;
    }
    /**
     * Establece el nombre del Critica.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	public void setEstado(String estado) {
        this.estado = estado;
    }
	public void setPuntuacion(String puntuacionl) {
        this.puntuacion = puntuacion;
    }
    /**
     * Regresa la descripción del Critica.
     * @return String
     */


    /**
     * Establece la descripción del Critica.
     * @return void
     */



}
