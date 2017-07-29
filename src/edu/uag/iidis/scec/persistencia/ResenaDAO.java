package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Resena;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class ResenaDAO {

    private Log log = LogFactory.getLog(ResenaDAO.class);

    public ResenaDAO() {
    }

    public Resena buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        Resena resena = null;
        try {
            List resenas = HibernateUtil.getSession()
                    .createQuery("from Resena where nombre=:nombre")
                    .setString("nombre", nombre)
                    .list();

            if ((resena != null) && (resenas.size() > 0)) {
                resena = (Resena)resenas.get(0);
            }

            if (resena == null) {
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

        return resena;
    }


    public Resena buscarPorId(Long idResena, boolean bloquear)
            throws ExcepcionInfraestructura {

        Resena resena = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idResena + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                resena = (Resena)HibernateUtil.getSession()
                                                .load(Resena.class,
                                                      idResena,
                                                      LockMode.UPGRADE);
            } else {
                resena = (Resena)HibernateUtil.getSession()
                                                .load(Resena.class,
                                                      idResena);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return resena;
    }

    public Collection ordenarResenasPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection resenas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Resena ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         resenas = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*criticaes = HibernateUtil.getSession()
                                    .createCriteria(Critica.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + resenas.size());
			log.debug(">buscarTodos() ---- contenido   " + resenas);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return resenas;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection resenas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            resenas = HibernateUtil.getSession()
                                    .createCriteria(Resena.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + resenas.size());
			log.debug(">buscarTodos() ---- contenido   " + resenas);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return resenas;
    }


    public Collection buscarPorEjemplo(Resena resena)
            throws ExcepcionInfraestructura {


        Collection resenas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Resena.class);
            resenas = criteria.add(Example.create(resena)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return resenas;
    }


    public void hazPersistente(Resena resena)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(resena)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(resena);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Resena resena)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(resena)");
        }

        try {
            HibernateUtil.getSession().delete(resena);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeResena(String nombreResena)
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

            String hql = "select nombre from Resena where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreResena);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreResena);
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

    public boolean modificar( Resena resena ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(resena)");

        }

        try {

            System.out.println(resena.toString());

            HibernateUtil.getSession().saveOrUpdate(resena);

            toReturn = true;

        } catch (HibernateException ex) {

            if (this.log.isWarnEnabled()) {

                this.log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }

        return toReturn;
    }


	public Collection buscarResena(String nombreResena)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Resena where nombre like '"+nombreResena+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreResena);
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
