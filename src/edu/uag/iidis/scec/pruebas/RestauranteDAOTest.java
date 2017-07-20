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

public class RestauranteDAOTest extends TestCase{

    
    public void testCrearRestauranteE() throws Exception {
        RestauranteDAO dao = new RestauranteDAO();

        Restaurante restaurante = new Restaurante(
            "CrearRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Restaurante restauranteb = dao.buscarPorNombre("CrearRestaurante");
            assertTrue(restauranteb != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("CrearRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
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
    public void testCrearRestauranteF() throws Exception {
        //Falla porque la placa esta en BD
        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();

            assertTrue(restaurante.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    
    public void testActualizarRestauranteE() throws Exception {



        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
            "ActualizaRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Restaurante restauranteB = dao.buscarPorNombre("ActualizaRestaurante");
            restauranteB.setNombre("ActualizaRestaurante");
            Boolean a = dao.modificar(restauranteB);
            assertTrue(a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("ActualizaRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
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
    public void testActualizarRestauranteF() throws Exception {



        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
            "ActualizaRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Restaurante restauranteB = dao.buscarPorNombre("ActualizaRestaurante");
            restauranteB.setId( Long.valueOf(0) );
            Boolean a = dao.modificar(restauranteB);
            assertTrue(! a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("ActualizaRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
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

        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.buscarTodos();
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("BuscarTodo");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
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

        RestauranteDAO dao = new RestauranteDAO();

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


    
    public void testExisteRestauranteE() throws Exception {


        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
            "Existe Restaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeRestaurante("Existe Restaurante");
            assertTrue(existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("Existe Restaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteRestauranteF() throws Exception {


        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
            "ExisteRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeRestaurante("ExisteRestaurante2");
            assertTrue(! existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("ExisteRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarRestauranteE() throws Exception {

        RestauranteDAO dao = new RestauranteDAO();

        Restaurante restaurante = new Restaurante(
            "EliminarRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("EliminarRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
            }
            HibernateUtil.commitTransaction();

            Restaurante restauranteb = dao.buscarPorNombre("EliminarRestaurante");

            assertTrue(restauranteb == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    /*
    public void testEliminarRestauranteF() throws Exception {

        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restauranteB = dao.buscarPorId(Long.valueOf(0), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(restauranteB);
            HibernateUtil.commitTransaction();

            assertTrue(restauranteB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/
    
    public void testordenarRestauranteesPorE() throws Exception {

        RestauranteDAO dao = new RestauranteDAO();
        Restaurante restaurante = new Restaurante(
            "OrdenarRestaurante", 
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
            dao.hazPersistente(restaurante);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.ordenarRestauranteesPor("nombre");
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Restaurante restaurante2 = dao.buscarPorNombre("OrdenarRestaurante");
            if (restaurante2 != null) {
              dao.hazTransitorio(restaurante2);
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
    public void testordenarRestauranteesPorF() throws Exception {

        RestauranteDAO dao = new RestauranteDAO();
        //Restaurante restaurante = new Restaurante("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(restaurante);
            Collection resultado = dao.ordenarRestauranteesPor("nombre");
            HibernateUtil.commitTransaction();
            Restaurante aux = (Restaurante)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(RestauranteDAOTest.class)) {

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
