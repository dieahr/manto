package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Acceso extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String nombrePrefijo;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String nombreUsuario;
    private String claveAcceso;


    public Acceso() {
    }

    public Acceso(Long id){
        this.id = id;
    }

    public Acceso(String nombre, String nombrePrefijo,String apellidoMaterno,String apellidoPaterno,String nombreUsuario, String claveAcceso){
        this.nombre=nombre;
        this.nombrePrefijo=nombrePrefijo;
		this.apellidoMaterno=apellidoMaterno;
		this.apellidoPaterno=apellidoPaterno;
		this.nombreUsuario=nombreUsuario;
        this.claveAcceso=claveAcceso;

    }

    /**
     * Regresa el id del Acceso.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Acceso.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Acceso.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
	public String getNombrePrefijo() {
        return this.nombrePrefijo;
    }
	public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
	public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
	public String getNombreUsuario() {
        return this.nombreUsuario;
    }
     public String getClaveAcceso() {
        return this.claveAcceso;
    }


    /**
     * Establece el nombre del Acceso.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public void setNombrePrefijo(String nombrePrefijo) {
        this.nombrePrefijo = nombrePrefijo;
    }
	public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
	public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
	public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    /**
     * Regresa la descripción del Acceso.
     * @return String
     */


    /**
     * Establece la descripción del Acceso.
     * @return void
     */



}
