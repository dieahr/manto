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
public final class FormaListadoExpediciones
        extends ValidatorForm {

    private Collection expediciones;
    private int contador;
	private String nombre;
    private String pais;

    public void setExpediciones(Collection expediciones) {
        this.expediciones = expediciones;
        if (expediciones != null) {
          this.contador = expediciones.size();
        } else
          this.contador = -1;
    }

    public Collection getExpediciones() {
        return (this.expediciones);
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

    public String getPais(){
        return(this.nombre);
    }

    public void setPais(String pais){
         this.pais = pais;
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        expediciones =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
