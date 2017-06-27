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

public class CriticaDAOTest extends TestCase{

    
    public void testCrearCriticaE() throws Exception {
        CriticaDAO dao = new CriticaDAO();

        Critica critica = new Critica(
            "CrearCritica", 
            "003",
            "003",
            "003"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Critica criticab = dao.buscarPorNombre("CrearCritica");
            assertTrue(criticab != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("CrearCritica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
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
    public void testCrearCriticaF() throws Exception {
        //Falla porque la placa esta en BD
        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
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
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();

            assertTrue(critica.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/


    public void testActualizarCriticaE() throws Exception {



        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
            "ActualizaCritica", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Critica criticaB = dao.buscarPorNombre("ActualizaCritica");
            criticaB.setNombre("ActualizaCritica");
            boolean a = dao.modificar(criticaB);
            assertTrue(a);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("ActualizaCritica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
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
    public void testActualizarCriticaF() throws Exception {
        //Falla porque la placa no se puede actualizar
        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
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
             dao.hazPersistente(critica);
             Critica criticaB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(criticaB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    
    public void testBuscarTodosE() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
            "BuscarTodo", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.buscarTodos();
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("BuscarTodo");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
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

        CriticaDAO dao = new CriticaDAO();

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


    
    public void testExisteCriticaE() throws Exception {


        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
            "Existe Critica", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeCritica("Existe Critica");
            assertTrue(existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("Existe Critica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteCriticaF() throws Exception {


        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
            "Existe Critica", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeCritica("Existe Critica2");
            assertTrue( ! existe);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("Existe Critica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarCriticaE() throws Exception {

        CriticaDAO dao = new CriticaDAO();

        Critica critica = new Critica(
            "EliminarCritica", 
            "011",
            "011",
            "011"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("EliminarCritica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
            }
            HibernateUtil.commitTransaction();

            Critica criticab = dao.buscarPorNombre("EliminarCritica");

            assertTrue(criticab == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    /*
    public void testEliminarCriticaF() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica criticaB = dao.buscarPorId(Long.valueOf(0), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(criticaB);
            HibernateUtil.commitTransaction();

            assertTrue(criticaB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/
    
    public void testordenarCriticaesPorE() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica critica = new Critica(
            "OrdenarCritica", 
            "012",
            "012",
            "012"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(critica);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Collection resultado = dao.ordenarCriticaesPor("nombre");
            assertTrue(resultado != null);
            HibernateUtil.commitTransaction();



            HibernateUtil.beginTransaction();
            Critica critica2 = dao.buscarPorNombre("OrdenarCritica");
            if (critica2 != null) {
              dao.hazTransitorio(critica2);
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
    public void testordenarCriticaesPorF() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        //Critica critica = new Critica("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(critica);
            Collection resultado = dao.ordenarCriticaesPor("nombre");
            HibernateUtil.commitTransaction();
            Critica aux = (Critica)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }*/

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(CriticaDAOTest.class)) {

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
