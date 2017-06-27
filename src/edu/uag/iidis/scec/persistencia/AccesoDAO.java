package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Acceso;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class AccesoDAO {

    private Log log = LogFactory.getLog(AccesoDAO.class);

    public AccesoDAO() {
    }


    public Acceso buscarPorId(Long idAcceso, boolean bloquear)
            throws ExcepcionInfraestructura {

        Acceso acceso = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idAcceso + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                acceso = (Acceso)HibernateUtil.getSession()
                                                .load(Acceso.class,
                                                      idAcceso,
                                                      LockMode.UPGRADE);
            } else {
                acceso = (Acceso)HibernateUtil.getSession()
                                                .load(Acceso.class,
                                                      idAcceso);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return acceso;
    }

    public Collection ordenarAccesosPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Acceso ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         accesos = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*accesos = HibernateUtil.getSession()
                                    .createCriteria(Acceso.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + accesos.size());
			log.debug(">buscarTodos() ---- contenido   " + accesos);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            accesos = HibernateUtil.getSession()
                                    .createCriteria(Acceso.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + accesos.size());
			log.debug(">buscarTodos() ---- contenido   " + accesos);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }


    public Collection buscarPorEjemplo(Acceso acceso)
            throws ExcepcionInfraestructura {


        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Acceso.class);
            accesos = criteria.add(Example.create(acceso)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }


    public void hazPersistente(Acceso acceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(acceso)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(acceso);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Acceso acceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(acceso)");
        }

        try {
            HibernateUtil.getSession().delete(acceso);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeAcceso(String nombreAcceso)
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

            String hql = "select nombre from Acceso where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreAcceso);
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

    public boolean modificar( Acceso acceso ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(estado)");

        }

        try {

            System.out.println(acceso.toString());

            HibernateUtil.getSession().saveOrUpdate(acceso);

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
    public Collection buscarImagen(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre = '"+nombreAcceso+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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

	public Collection buscarAcceso(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre like '"+nombreAcceso+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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

    public Collection buscarEstado(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre = '"+nombreAcceso+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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
