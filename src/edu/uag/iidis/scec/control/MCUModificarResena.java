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
import edu.uag.iidis.scec.modelo.Resena;
import edu.uag.iidis.scec.vista.FormaModificarResena;

public class MCUModificarResena extends MappingDispatchAction {

    private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    public ActionForward solicitarModificarResena(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (this.log.isDebugEnabled()) {

            this.log.debug(">solicitarModificarResena");

        }

        return mapping.findForward("exito");

    }

    public ActionForward procesarModificarResena(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Im here");

        if (this.log.isDebugEnabled()) {

            this.log.debug("> procesarModificarResena");

        }

        FormaModificarResena formaModificarResena = (FormaModificarResena) form;

        System.out.println(formaModificarResena);
        //Critica(String nombre, String descripcion,String hotel,String nivel);
        Resena resena = new Resena(
                formaModificarResena.getNombre(),
                formaModificarResena.getDescripcion(),
                formaModificarResena.getEstado(),
                formaModificarResena.getPuntuacion()
        );

        resena.setId(formaModificarResena.getId());

        ManejadorResenas manejadorResenas = new ManejadorResenas();

        manejadorResenas.modificarResena(resena );
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");

    }
}
