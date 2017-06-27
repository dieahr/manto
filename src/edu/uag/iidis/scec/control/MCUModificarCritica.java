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
import edu.uag.iidis.scec.modelo.Critica;
import edu.uag.iidis.scec.vista.FormaModificarCritica;

public class MCUModificarCritica extends MappingDispatchAction {

    private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    public ActionForward solicitarModificarCritica(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (this.log.isDebugEnabled()) {

            this.log.debug(">solicitarModificarCritica");

        }

        return mapping.findForward("exito");

    }

    public ActionForward procesarModificarCritica(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Im here");

        if (this.log.isDebugEnabled()) {

            this.log.debug("> procesarModificarCritica");

        }

        FormaModificarCritica formaModificarCritica = (FormaModificarCritica) form;

        System.out.println(formaModificarCritica);
        //Critica(String nombre, String descripcion,String hotel,String nivel);
        Critica critica = new Critica(
                formaModificarCritica.getNombre(),
                formaModificarCritica.getDescripcion(),
                formaModificarCritica.getHotel(),
                formaModificarCritica.getNivel()
        );

        critica.setId(formaModificarCritica.getId());

        ManejadorCriticaes manejadorCriticaes = new ManejadorCriticaes();

        manejadorCriticaes.modificarCritica( critica );
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");

    }
}
