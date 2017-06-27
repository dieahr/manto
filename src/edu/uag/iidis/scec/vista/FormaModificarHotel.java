package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class FormaModificarHotel extends ValidatorForm  {

    private Long id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String horario;
    private String estado;
    private String pais;
    private String direccion;
    Collection estados;
    private String imagen;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return (this.nombre);
    }
    public String getImagen() {
        return (this.imagen);
    }
    public String getDescripcion() {
        return (this.descripcion);
    }
	public String getPrecio() {
        return (this.precio);
    }
	public String getHorario() {
        return (this.horario);
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

    public Collection getEstados(){
            return (this.estados);
    }

    public void setId(Long id) {
        this.id = id;
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
	public void setImagen(String imagen) {
        this.imagen = imagen;
    }
	public void setPrecio(String precio) {
        this.precio = precio;
    }
	public void setHorario(String horario) {
        this.horario = horario;
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

    @Override
    public String toString() {
        return "FormaModificarHotel{" + "id=" + id + ", nombre=" + nombre +
                    ", descripcion=" + descripcion + ", precio=" + precio +
                    ", horario=" + horario + ", estado=" + estado +
                    ", pais=" + pais + ", direccion=" + direccion + ", estados=" + estados +
                    ", imagen=" + imagen +
                '}';
    }



}
