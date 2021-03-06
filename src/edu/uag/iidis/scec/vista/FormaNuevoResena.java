package edu.uag.iidis.scec.vista;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;

/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaNuevoResena
        extends ValidatorForm {

    private String nombre;
    private String descripcion;
	private String estado;
	private String puntuacion;


    public String getNombre() {
        return (this.nombre);
    }
    public String getDescripcion() {
        return (this.descripcion);
    }
	public String getEstado() {
        return (this.estado);
    }
	public String getPuntuacion() {
        return (this.puntuacion);
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	public void setEstado(String estado) {
        this.estado = estado;
    }
	public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        descripcion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
