package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Expedicion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class ExpedicionDAO {

    private Log log = LogFactory.getLog(ExpedicionDAO.class);

    public ExpedicionDAO() {
    }


    public Expedicion buscarPorId(Long idExpedicion, boolean bloquear)
            throws ExcepcionInfraestructura {

        Expedicion expedicion = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idExpedicion + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                expedicion = (Expedicion)HibernateUtil.getSession()
                                                .load(Expedicion.class,
                                                      idExpedicion,
                                                      LockMode.UPGRADE);
            } else {
                expedicion = (Expedicion)HibernateUtil.getSession()
                                                .load(Expedicion.class,
                                                      idExpedicion);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return expedicion;
    }

    public Expedicion buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        Expedicion expedicion = null;
        try {
            List expediciones = HibernateUtil.getSession()
                    .createQuery("from Expedicion where nombre=:nombre")
                    .setString("nombre", nombre)
                    .list();

            if ((expediciones != null) && (expediciones.size() > 0)) {
                expedicion = (Expedicion)expediciones.get(0);
            }

            if (expedicion == null) {
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

        return expedicion;
    }

    public Collection ordenarExpedicionesPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection expediciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Expedicion ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         expediciones = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*restaurantees = HibernateUtil.getSession()
                                    .createCriteria(Restaurante.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + expediciones.size());
			log.debug(">buscarTodos() ---- contenido   " + expediciones);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return expediciones;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection expediciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            expediciones = HibernateUtil.getSession()
                                    .createCriteria(Expedicion.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + expediciones.size());
			log.debug(">buscarTodos() ---- contenido   " + expediciones);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return expediciones;
    }


    public Collection buscarPorEjemplo(Expedicion expedicion)
            throws ExcepcionInfraestructura {


        Collection expediciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Expedicion.class);
            expediciones = criteria.add(Example.create(expedicion)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return expediciones;
    }


    public void hazPersistente(Expedicion expedicion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(expedicion)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(expedicion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Expedicion expedicion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(expedicion)");
        }

        try {
            HibernateUtil.getSession().delete(expedicion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeExpedicion(String nombreExpedicion)
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

            String hql = "select nombre from Expedicion where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreExpedicion);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreExpedicion);
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

    public boolean modificar( Expedicion expedicion ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(estado)");

        }

        try {

            System.out.println(expedicion.toString());

            HibernateUtil.getSession().saveOrUpdate(expedicion);

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
    public Collection buscarImagen(String nombreExpedicion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Expedicion where nombre = '"+nombreExpedicion+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreExpedicion);
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

	public Collection buscarExpedicion(String nombreExpedicion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Expedicion where nombre like '"+nombreExpedicion+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreExpedicion);
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

    public Collection buscarEstado(String nombreExpedicion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Expedicion where nombre = '"+nombreExpedicion+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreExpedicion);
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
