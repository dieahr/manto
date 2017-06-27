package edu.uag.iidis.scec.control;

import java.util.Collection;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

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
import java.io.*;
import java.util.*;
import org.apache.struts.upload.FormFile;


public final class MCURegistrarCritica
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);




    public ActionForward procesarRegistroCritica(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroCritica");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        String filePath = getServlet().getServletContext().getRealPath("/");
        log.debug("ruta: " + filePath);
        File folder = new File(filePath);
        if(!folder.exists()){
            folder.mkdir();
        }
        FormaNuevoCritica forma = (FormaNuevoCritica)form;

        Critica critica = new Critica( forma.getNombre(),
                          forma.getDescripcion(),forma.getHotel(),forma.getNivel() );

        ManejadorCriticaes mr = new ManejadorCriticaes();
        int resultado = mr.crearCritica(critica);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreCriticaYaExiste",
                                               forma.getNombre()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}
