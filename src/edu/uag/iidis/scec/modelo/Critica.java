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
public class Critica extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
	private String hotel;
	private String nivel;

    public Critica() {
    }

    public Critica(Long id){
        this.id = id;
    }

    public Critica(String nombre, String descripcion,String hotel,String nivel){
        this.nombre=nombre;
        this.descripcion=descripcion;
		this.hotel=hotel;
		this.nivel=nivel;
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
	public String getHotel() {
        return this.hotel;
    }
	public String getNivel() {
        return this.nivel;
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
	public void setHotel(String hotel) {
        this.hotel = hotel;
    }
	public void setNivel(String nivel) {
        this.nivel = nivel;
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
