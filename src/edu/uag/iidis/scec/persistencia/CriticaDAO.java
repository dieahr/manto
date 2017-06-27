package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Critica;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class CriticaDAO {

    private Log log = LogFactory.getLog(CriticaDAO.class);

    public CriticaDAO() {
    }

    public Critica buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        Critica critica = null;
        try {
            List criticas = HibernateUtil.getSession()
                    .createQuery("from Critica where nombre=:nombre")
                    .setString("nombre", nombre)
                    .list();

            if ((criticas != null) && (criticas.size() > 0)) {
                critica = (Critica)criticas.get(0);
            }

            if (critica == null) {
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

        return critica;
    }


    public Critica buscarPorId(Long idCritica, boolean bloquear)
            throws ExcepcionInfraestructura {

        Critica critica = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idCritica + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                critica = (Critica)HibernateUtil.getSession()
                                                .load(Critica.class,
                                                      idCritica,
                                                      LockMode.UPGRADE);
            } else {
                critica = (Critica)HibernateUtil.getSession()
                                                .load(Critica.class,
                                                      idCritica);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return critica;
    }

    public Collection ordenarCriticaesPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Critica ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         criticaes = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*criticaes = HibernateUtil.getSession()
                                    .createCriteria(Critica.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + criticaes.size());
			log.debug(">buscarTodos() ---- contenido   " + criticaes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            criticaes = HibernateUtil.getSession()
                                    .createCriteria(Critica.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + criticaes.size());
			log.debug(">buscarTodos() ---- contenido   " + criticaes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }


    public Collection buscarPorEjemplo(Critica critica)
            throws ExcepcionInfraestructura {


        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Critica.class);
            criticaes = criteria.add(Example.create(critica)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }


    public void hazPersistente(Critica critica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(critica)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(critica);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Critica critica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(critica)");
        }

        try {
            HibernateUtil.getSession().delete(critica);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeCritica(String nombreCritica)
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

            String hql = "select nombre from Critica where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreCritica);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreCritica);
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

    public boolean modificar( Critica critica ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(critica)");

        }

        try {

            System.out.println(critica.toString());

            HibernateUtil.getSession().saveOrUpdate(critica);

            toReturn = true;

        } catch (HibernateException ex) {

            if (this.log.isWarnEnabled()) {

                this.log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }

        return toReturn;
    }


	public Collection buscarCritica(String nombreCritica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Critica where nombre like '"+nombreCritica+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreCritica);
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
