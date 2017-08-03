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

public class ResenaDAOTest extends TestCase{

    
    public void testCrearResenaE() throws Exception {
        ResenaDAO dao = new ResenaDAO();

        Resena resena = new Resena(
            "CrearResena", 
            "003",
            "003",
            "003"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Resena resenab = dao.buscarPorNombre("CrearResena");
            assertTrue(resenab != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("CrearResena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
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
    public void testCrearResenaF() throws Exception {
        //Falla porque la placa esta en BD
        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
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
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();

            assertTrue(resena.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/


    public void testActualizarResenaE() throws Exception {



        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
            "ActualizaResena", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Resena resenaB = dao.buscarPorNombre("ActualizaResena");
            resenaB.setNombre("ActualizaResena");
            boolean a = dao.modificar(resenaB);
            assertTrue(a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("ActualizaResena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
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
    public void testActualizarResenaF() throws Exception {
        //Falla porque la placa no se puede actualizar
        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
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
             dao.hazPersistente(resena);
             Resena resenaB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(resenaB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    
    public void testBuscarTodosE() throws Exception {

        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
            "BuscarTodo", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.buscarTodos();
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("BuscarTodo");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
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

        ResenaDAO dao = new ResenaDAO();

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


    
    public void testExisteResenaE() throws Exception {


        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
            "Existe Resena", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeResena("Existe Resena");
            assertTrue(existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("Existe Resena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteResenaF() throws Exception {


        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
            "Existe Resena", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeResena("Existe Resena2");
            assertTrue( ! existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("Existe Resena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarResenaE() throws Exception {

        ResenaDAO dao = new ResenaDAO();

        Resena resena = new Resena(
            "EliminarResena", 
            "011",
            "011",
            "011"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("EliminarResena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
            }
            HibernateUtil.commitTransaction();

            Resena resenab = dao.buscarPorNombre("EliminarResena");

            assertTrue(resenab == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    /*
    public void testEliminarResenaF() throws Exception {

        ResenaDAO dao = new ResenaDAO();
        Resena resenaB = dao.buscarPorId(Long.valueOf(0), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(resenaB);
            HibernateUtil.commitTransaction();

            assertTrue(resenaB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/
    
    public void testordenarResenasPorE() throws Exception {

        ResenaDAO dao = new ResenaDAO();
        Resena resena = new Resena(
            "OrdenarResena", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(resena);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.ordenarResenasPor("nombre");
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Resena resena2 = dao.buscarPorNombre("OrdenarResena");
            if (resena2 != null) {
              dao.hazTransitorio(resena2);
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
    public void testordenarResenasPorF() throws Exception {

        ResenaDAO dao = new ResenaDAO();
        //Resena resena = new Resena("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(resena);
            Collection resultado = dao.ordenarResenasPor("nombre");
            HibernateUtil.commitTransaction();
            Resena aux = (Resena)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(ResenaDAOTest.class)) {

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
