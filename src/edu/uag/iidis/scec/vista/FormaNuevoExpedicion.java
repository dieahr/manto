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
public final class FormaNuevoExpedicion
        extends ValidatorForm {

    private String nombre;
    private String descripcion;
	private String cantidad;
	private String estado;
    private String pais;
    private String direccion;
    private String fecha;
    private String hora;
	Collection estados;
    private FormFile imagen;


    public String getNombre() {
        return (this.nombre);
    }
    public FormFile getImagen() {
        return (this.imagen);
    }
    public String getDescripcion() {
        return (this.descripcion);
    }
	public String getCantidad() {
        return (this.cantidad);
    }
	public String getEstado() {
        return (this.estado);
    }
    public String getPais() {
        return (this.pais);
    }
    public String getDireccion() {
        return (this.direccion);
    }
    public String getFecha(){
        return (this.fecha);
    }
    public String getHora(){
        return (this.hora);
    }
	public Collection getEstados(){
		return (this.estados);
	}

	public void setEstados(Collection estados) {
        this.estados = estados;
    }
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	public void setImagen(FormFile imagen) {
        this.imagen = imagen;
    }
	public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setHora(String hora){
        this.hora = hora;
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
