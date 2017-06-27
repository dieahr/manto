package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import net.webservicex.*;


public final class MCUListarCriticaes
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarListarCriticaes(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarCriticaes");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoCriticaes forma = (FormaListadoCriticaes)form;

        ManejadorCriticaes mr = new ManejadorCriticaes();
        Collection resultado = mr.listarCriticaes();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setCriticaes(resultado);
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }
	 public ActionForward buscarCritica(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarCriticaes");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoCriticaes forma = (FormaListadoCriticaes)form;

        ManejadorCriticaes mr = new ManejadorCriticaes();
        Collection resultado = mr.listarCriticaesPorNombre(forma.getNombre());

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setCriticaes(resultado);
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }





}
