package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Resena;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.ResenaDAO;
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
public class ManejadorResenas {
    private Log log = LogFactory.getLog(ManejadorResenas.class);
    private ResenaDAO resenaDAO;

    public ManejadorResenas() {
        resenaDAO = new ResenaDAO();
    }


    public Collection listarResenas() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = resenaDAO.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection ordenarResenasPor(String attribute) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = resenaDAO.ordenarResenasPor(attribute);
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

	public Collection listarResenasPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = resenaDAO.buscarResena(nombre);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarResena(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarResena(resena)");
        }
        try {
            HibernateUtil.beginTransaction();
            Resena resena = resenaDAO.buscarPorId(id, true);
            if (resena != null) {
              resenaDAO.hazTransitorio(resena);
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



    public int crearResena(Resena resena) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarResena(resena)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (resenaDAO.existeResena(resena.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               resenaDAO.hazPersistente(resena);

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

    public boolean modificarResena(Resena resena) {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">guardarResena(resena)");

        }

        try {

            HibernateUtil.beginTransaction();
            toReturn = this.resenaDAO.modificar( resena );

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
