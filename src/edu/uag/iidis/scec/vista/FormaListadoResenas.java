package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaListadoResenas
        extends ValidatorForm {

    private Collection resenas;
    private int contador;
	private String nombre;

    public void setResenas(Collection resenas) {
        this.resenas = resenas;
        if (resenas != null) {
          this.contador = resenas.size();
        } else
          this.contador = -1;
    }

    public Collection getResenas() {
        return (this.resenas);
    }

    public int getContador() {
        return (this.contador);
    }
	public String getNombre(){
        return(this.nombre);
    }

	public void setNombre(String nombre){
         this.nombre = nombre;
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        resenas =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
