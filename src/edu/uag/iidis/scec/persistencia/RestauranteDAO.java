package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Restaurante;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class RestauranteDAO {

    private Log log = LogFactory.getLog(RestauranteDAO.class);

    public RestauranteDAO() {
    }


    public Restaurante buscarPorId(Long idRestaurante, boolean bloquear)
            throws ExcepcionInfraestructura {

        Restaurante restaurante = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idRestaurante + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                restaurante = (Restaurante)HibernateUtil.getSession()
                                                .load(Restaurante.class,
                                                      idRestaurante,
                                                      LockMode.UPGRADE);
            } else {
                restaurante = (Restaurante)HibernateUtil.getSession()
                                                .load(Restaurante.class,
                                                      idRestaurante);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return restaurante;
    }

    public Restaurante buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        Restaurante restaurante = null;
        try {
            List restaurantes = HibernateUtil.getSession()
                    .createQuery("from Restaurante where nombre=:nombre")
                    .setString("nombre", nombre)
                    .list();

            if ((restaurantes != null) && (restaurantes.size() > 0)) {
                restaurante = (Restaurante)restaurantes.get(0);
            }

            if (restaurante == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombre(" + nombre + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return restaurante;
    }

    public Collection ordenarRestauranteesPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection restaurantees;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Restaurante ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         restaurantees = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*restaurantees = HibernateUtil.getSession()
                                    .createCriteria(Restaurante.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + restaurantees.size());
			log.debug(">buscarTodos() ---- contenido   " + restaurantees);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return restaurantees;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection restaurantees;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            restaurantees = HibernateUtil.getSession()
                                    .createCriteria(Restaurante.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + restaurantees.size());
			log.debug(">buscarTodos() ---- contenido   " + restaurantees);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return restaurantees;
    }


    public Collection buscarPorEjemplo(Restaurante restaurante)
            throws ExcepcionInfraestructura {


        Collection restaurantees;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Restaurante.class);
            restaurantees = criteria.add(Example.create(restaurante)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return restaurantees;
    }


    public void hazPersistente(Restaurante restaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(restaurante)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(restaurante);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Restaurante restaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(restaurante)");
        }

        try {
            HibernateUtil.getSession().delete(restaurante);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeRestaurante(String nombreRestaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {


//            String consultaCuentaRoles =
//            "select count(*) from Ciudad r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles,
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato

            String hql = "select nombre from Restaurante where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreRestaurante);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreRestaurante);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return false;
            }

            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public boolean modificar( Restaurante restaurante ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(estado)");

        }

        try {

            System.out.println(restaurante.toString());

            HibernateUtil.getSession().saveOrUpdate(restaurante);

            toReturn = true;

        } catch (HibernateException ex) {

            if (this.log.isWarnEnabled()) {

                this.log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }

        return toReturn;
    }

    //cambios
    public Collection buscarImagen(String nombreRestaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Restaurante where nombre = '"+nombreRestaurante+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreRestaurante);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }

            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

	public Collection buscarRestaurante(String nombreRestaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Restaurante where nombre like '"+nombreRestaurante+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreRestaurante);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }

            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection buscarEstado(String nombreRestaurante)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Restaurante where nombre = '"+nombreRestaurante+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreRestaurante);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }

            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }
}
