package edu.uag.iidis.scec.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.modelo.Expedicion;
import edu.uag.iidis.scec.vista.FormaModificarExpedicion;

public class MCUModificarExpedicion extends MappingDispatchAction {

    private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    public ActionForward solicitarModificarExpedicion(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (this.log.isDebugEnabled()) {

            this.log.debug(">solicitarModificarEstado");

        }

        return mapping.findForward("exito");

    }

    public ActionForward procesarModificarExpedicion(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Im here");

        if (this.log.isDebugEnabled()) {

            this.log.debug("> procesarModificarEstado");

        }

        FormaModificarExpedicion formaModificarExpedicion = (FormaModificarExpedicion) form;

        System.out.println(formaModificarExpedicion);
        //Restaurante(String nombre, String descripcion,String precio,String horario,String estado, String imagen, String pais, String direccion);
        Expedicion expedicion = new Expedicion(
                formaModificarExpedicion.getNombre(),
                formaModificarExpedicion.getDescripcion(),
                formaModificarExpedicion.getCantidad(),
                formaModificarExpedicion.getEstado(),
                formaModificarExpedicion.getPais(),
                formaModificarExpedicion.getDireccion(),
                formaModificarExpedicion.getFecha(),
                formaModificarExpedicion.getHora()
        );

        expedicion.setId(formaModificarExpedicion.getId());

        //ManejadorEstados manejadorEstados = new ManejadorEstados();
        ManejadorExpediciones manejadorExpediciones = new ManejadorExpediciones();

        //manejadorEstados.modificarEstado(estado);
        manejadorExpediciones.modificarExpedicion(expedicion);
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");

    }
}
