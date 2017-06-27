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


public class UsuarioDAOTest extends TestCase {

    private static UsuarioDAO dao = null;
    private static RolDAO rolDAO = null;

    protected void setUp() throws Exception {
        // se ejecuta al inicio de cada método de prueba
    }

    protected void tearDown() {
        // se ejecuta al final de cada método de prueba
    }

    public void testCrearUsuario() throws Exception {
        Usuario usuario = new Usuario(
                    new NombrePersona("DR.",
                                      "Fujencio",
                                      "Martines", "Martines", 
                                      "Funje", "FMM"),
                    new Credencial("flyzx","123"));
        try {
            HibernateUtil.beginTransaction();
            dao.hazPersistente(usuario);
            HibernateUtil.commitTransaction();

            Usuario usuB = dao.buscarPorNombreUsuario("flyzx");

            assertTrue(usuB != null);

            HibernateUtil.beginTransaction();
            Usuario usuario2 = dao.buscarPorNombreUsuario("flyzx");
            if (usuario2 != null) {
              dao.hazTransitorio(usuario2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }

    }

    public void testEliminarUsuario() {
        Usuario usuario2 = new Usuario(
                    new NombrePersona("DR.",
                                      "Fujencio",
                                      "Martines", "Martines", 
                                      "Funje", "FMM"),
                    new Credencial("flyzx","123"));
        try {
            HibernateUtil.beginTransaction();
            dao.hazPersistente(usuario2);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Usuario usuario = dao.buscarPorNombreUsuario("flyzx");
            if (usuario != null) {
              dao.hazTransitorio(usuario);
            }
            HibernateUtil.commitTransaction();
            Usuario usuB = dao.buscarPorNombreUsuario("flyzx");

            assertTrue(usuB == null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }

    }


    public void testBuscarUsuarioPorId() throws Exception {
        Usuario usuario;
        try {
            usuario = dao.buscarPorId(new Long(1), false);
            assertTrue(usuario.getId() != null);
            assertTrue(usuario.getNombre()
                              .getApellidoPaterno()
                              .equals("Osuna"));
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testBuscarPorEjemplo() throws Exception {
        Usuario usuario = new Usuario();
        Collection usuarios;

        usuario.setCredencial(new Credencial("gosuna", null));
        try {
            usuarios = dao.buscarPorEjemplo(usuario);
            assertTrue(usuarios.size() == 1);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testBuscarTodos() throws Exception {
        Collection usuarios;

        try {
            usuarios = dao.buscarTodos();
            assertTrue(usuarios.size() >= 1);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    public void testVerificarRol() throws Exception {
        Usuario usuario;
        try {
            usuario = dao.buscarPorId(new Long(1), false);
            assertTrue(usuario.getRoles().size() == 2);
        } catch (Exception e) {
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(UsuarioDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite

                //SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                //ddlExport.create(false, true);

                dao = new UsuarioDAO();
                rolDAO = new RolDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                dao = null;
                rolDAO = null;
            }
        };

        return suite;
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }

}
