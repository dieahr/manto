package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Expedicion;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.ExpedicionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;
import net.webservicex.*;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
public class ManejadorExpediciones {
    private Log log = LogFactory.getLog(ManejadorExpediciones.class);
    private ExpedicionDAO expedicionDAO;

    public ManejadorExpediciones() {
        expedicionDAO = new ExpedicionDAO();
    }


    public Collection listarExpediciones() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = expedicionDAO.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection ordenarExpedicionesPor(String attribute) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = expedicionDAO.ordenarExpedicionesPor(attribute);
            if (log.isDebugEnabled()) {
                log.debug(">ret4rn h6te3");
            }
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

	public Collection listarExpedicionesPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = expedicionDAO.buscarExpedicion(nombre);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
        
        

    public Collection buscaEstado(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = expedicionDAO.buscarEstado(nombre);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarExpedicion(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarExpedicion(expedicion)");
        }
        try {
            HibernateUtil.beginTransaction();
            Expedicion expedicion = expedicionDAO.buscarPorId(id, true);
            if (expedicion != null) {
              expedicionDAO.hazTransitorio(expedicion);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    //cambios
    public Collection buscaImagen(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = expedicionDAO.buscarImagen(nombre);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection getService(String pais,String path) {
        Collection<DataService> resultado=null;
        ArrayList<DataService> b =  new ArrayList<>();
        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }
        String a = getCurrencyByCountry("Mexico");
        log.error(path);

        DataService d = new DataService(getData(a,path));
        b.add(d);
        resultado = b;
        return resultado;
    }

    public int crearExpedicion(Expedicion expedicion) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarExpedicion(expedicion)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (expedicionDAO.existeExpedicion(expedicion.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               expedicionDAO.hazPersistente(expedicion);

               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }
    private static String getCurrencyByCountry(java.lang.String countryName) {
        Country service = new net.webservicex.Country();
        CountrySoap port = service.getCountrySoap();
        return port.getCurrencyByCountry(countryName);
    }

    public boolean modificarExpedicion(Expedicion expedicion) {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">guardarEstado(estado)");

        }

        try {

            HibernateUtil.beginTransaction();

//            Estado estadoByID = this.estadoDAO.buscarPorId(estado.getId(), true);
//
//            estadoByID.setNombre(estado.getNombre());
//            estadoByID.setDescripcion(estado.getDescripcion());

            //toReturn = this.estadoDAO.modificar(estado);
            toReturn = this.expedicionDAO.modificar( expedicion );

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura ex) {

            HibernateUtil.rollbackTransaction();

            if (this.log.isWarnEnabled()) {

                this.log.warn("< ExcepcionInfraestructura");

            }

        } finally {

            HibernateUtil.closeSession();

        }

        return toReturn;
    }

    public String getData(String cities,String path){
        String service ="";
        try {


            File fXmlFile = new File(path+"input.xml");
            FileWriter w = new FileWriter(fXmlFile);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(cities);
            wr.close();
            bw.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
            NodeList nList = doc.getElementsByTagName("Table");

            int temp = 0;
            org.w3c.dom.Node nNode = nList.item(temp);
            service += nNode.getTextContent();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

}
