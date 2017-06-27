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
public final class FormaListadoUsuarios
        extends ValidatorForm {

    private Collection usuarios;
    private int contador;
	  private String nombre;
    private String pais;
    private String nombrePrefijo;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreUsuario;
    private String claveAcceso;



    public void setUsuarios(Collection usuarios) {
        this.usuarios = usuarios;
        if (usuarios != null) {
          this.contador = usuarios.size();
        } else
          this.contador = -1;
    }

    public Collection getUsuarios() {
        return (this.usuarios);
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

    public String getnombrePrefijo(){
        return(this.nombrePrefijo);
    }

    public void setnombrePrefijo(String nombrePrefijo){
         this.nombrePrefijo = nombrePrefijo;
    }

    public String getapellidoPaterno(){
        return(this.apellidoPaterno);
    }

    public void setapellidoPaterno(String apellidoPaterno){
         this.apellidoPaterno = apellidoPaterno;
    }

    public String getapellidoMaterno(){
        return(this.apellidoMaterno);
    }

    public void setapellidoMaterno(String apellidoMaterno){
         this.apellidoMaterno = apellidoMaterno;
    }

    public String getnombreUsuario(){
        return(this.nombreUsuario);
    }

    public void setnombreUsuario(String nombreUsuario){
         this.nombreUsuario = nombreUsuario;
    }

    public String getclaveAcceso(){
        return(this.claveAcceso);
    }

    public void setclaveAcceso(String claveAcceso){
         this.claveAcceso = claveAcceso;
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        usuarios =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
