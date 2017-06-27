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


public final class MCURegistrarHotel
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroHotel(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroHotel");
        }
		FormaNuevoHotel forma = (FormaNuevoHotel)form;

        ManejadorEstados mr = new ManejadorEstados();
        Collection resultado = mr.listarEstados();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setEstados(resultado);
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



    public ActionForward procesarRegistroHotel(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroHotel");
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
        FormaNuevoHotel forma = (FormaNuevoHotel)form;
        FormFile file = forma.getImagen();
        
        System.out.println("imagen --- " + file == null);

        String fileName = file.getFileName();
        File newFile =  null;
        if(!("").equals(fileName)){

            newFile = new File(filePath, fileName);

            if(!newFile.exists()){
              FileOutputStream fos = new FileOutputStream(newFile);
              fos.write(file.getFileData());
              fos.flush();
              fos.close();
            }
        }else {
          fileName = "hotel001.jpg";
        }
        Hotel hotel = new Hotel(forma.getNombre(),
                          forma.getDescripcion(),forma.getPrecio(),forma.getHorario(),forma.getEstado(),fileName,forma.getPais(),forma.getDireccion());

        ManejadorHoteles mr = new ManejadorHoteles();
        int resultado = mr.crearHotel(hotel);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreHotelYaExiste",
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
