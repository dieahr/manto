package edu.uag.iidis.scec.pruebas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;

public class ExpedicionDAOTest extends TestCase{

    
    public void testCrearExpedicionE() throws Exception {
        ExpedicionDAO dao = new ExpedicionDAO();

        Expedicion expedicion = new Expedicion(
            "CrearExpedicion", 
            "003",
            "003",
            "003",
            "003", 
            "003", 
            "003", 
            "003"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Expedicion expedicionb = dao.buscarPorNombre("CrearExpedicion");
            assertTrue(expedicionb != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("CrearExpedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    /*
    public void testCrearHotelF() throws Exception {
        //Falla porque la placa esta en BD
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "003", 
            "003",
            "003",
            "003",
            "003", 
            "003", 
            "003", 
            "003"
        );

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();

            assertTrue(hotel.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    
    public void testActualizarExpedicionE() throws Exception {



        ExpedicionDAO dao = new ExpedicionDAO();
        Expedicion expedicion = new Expedicion(
            "ActualizaExpedicion", 
            "012",
            "012",
            "012",
            "012", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Expedicion expedicionB = dao.buscarPorNombre("ActualizaExpedicion");
            expedicionB.setNombre("ActualizaExpedicion");
            Boolean a = dao.modificar(expedicionB);
            assertTrue(a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("ActualizaExpedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }

            
    }
    /*
    public void testActualizarHotelF() throws Exception {



        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "ActualizaHotel", 
            "012",
            "012",
            "012",
            "012", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Hotel hotelB = dao.buscarPorNombre("ActualizaHotel");
            hotelB.setId( Long.valueOf(0) );
            Boolean a = dao.modificar(hotelB);
            assertTrue(! a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Hotel hotel2 = dao.buscarPorNombre("ActualizaHotel");
            if (hotel2 != null) {
              dao.hazTransitorio(hotel2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }

            
    }*/

    
    public void testBuscarTodosE() throws Exception {

        ExpedicionDAO dao = new ExpedicionDAO();
        Expedicion expedicion = new Expedicion(
            "BuscarTodo", 
            "012",
            "012",
            "012",
            "012", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.buscarTodos();
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("BuscarTodo");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    /*
    public void testBuscarTodosF() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
            Collection resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();

            assertTrue(resultado != null);
            assertTrue("La busqueda fallo",resultado.isEmpty());
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/


    
    public void testExisteExpedicionE() throws Exception {


        ExpedicionDAO dao = new ExpedicionDAO();
        Expedicion expedicion = new Expedicion(
            "Existe Expedicion", 
            "012",
            "012",
            "012",
            "012", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeExpedicion("Existe Expedicion");
            assertTrue(existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("Existe Expedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteExpedicionF() throws Exception {


        ExpedicionDAO dao = new ExpedicionDAO();
        Expedicion expedicion = new Expedicion(
            "ExisteExpedicion", 
            "012",
            "012",
            "012",
            "012", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeExpedicion("ExisteExpedicion2");
            assertTrue(! existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("ExisteExpedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarExpedicionE() throws Exception {

        ExpedicionDAO dao = new ExpedicionDAO();

        Expedicion expedicion = new Expedicion(
            "EliminarExpedicion", 
            "011",
            "011",
            "011",
            "011", 
            "011", 
            "011", 
            "011"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("EliminarExpedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

            Expedicion expedicionb = dao.buscarPorNombre("EliminarExpedicion");

            assertTrue(expedicionb == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    /*
    public void testEliminarHotelF() throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotelB = dao.buscarPorId(Long.valueOf(0), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(hotelB);
            HibernateUtil.commitTransaction();

            assertTrue(hotelB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/
    
    public void testordenarExpedicionesPorE() throws Exception {

        ExpedicionDAO dao = new ExpedicionDAO();
        Expedicion expedicion = new Expedicion(
            "OrdenarExpedicion", 
            "012",
            "012",
            "012",
            "012", 
            "012", 
            "012", 
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(expedicion);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.ordenarExpedicionesPor("nombre");
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Expedicion expedicion2 = dao.buscarPorNombre("OrdenarExpedicion");
            if (expedicion2 != null) {
              dao.hazTransitorio(expedicion2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    /*
    public void testordenarHotelesPorF() throws Exception {

        HotelDAO dao = new HotelDAO();
        //Hotel hotel = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(hotel);
            Collection resultado = dao.ordenarHotelesPor("nombre");
            HibernateUtil.commitTransaction();
            Hotel aux = (Hotel)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(ExpedicionDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite

                //SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                //ddlExport.create(false, true);

                //dao = new UsuarioDAO();
                //rolDAO = new RolDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                //dao = null;
                //rolDAO = null;
            }
        };

        return suite;
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }





}
