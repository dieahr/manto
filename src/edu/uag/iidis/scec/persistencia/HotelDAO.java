package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Hotel;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class HotelDAO {

    private Log log = LogFactory.getLog(HotelDAO.class);

    public HotelDAO() {
    }


    public Hotel buscarPorId(Long idHotel, boolean bloquear)
            throws ExcepcionInfraestructura {

        Hotel hotel = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idHotel + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                hotel = (Hotel)HibernateUtil.getSession()
                                                .load(Hotel.class,
                                                      idHotel,
                                                      LockMode.UPGRADE);
            } else {
                hotel = (Hotel)HibernateUtil.getSession()
                                                .load(Hotel.class,
                                                      idHotel);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return hotel;
    }

    public Hotel buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        Hotel hotel = null;
        try {
            List hotels = HibernateUtil.getSession()
                    .createQuery("from Hotel where nombre=:nombre")
                    .setString("nombre", nombre)
                    .list();

            if ((hotels != null) && (hotels.size() > 0)) {
                hotel = (Hotel)hotels.get(0);
            }

            if (hotel == null) {
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

        return hotel;
    }

    public Collection ordenarHotelesPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection hoteles;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Hotel ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         hoteles = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*hoteles = HibernateUtil.getSession()
                                    .createCriteria(Hotel.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + hoteles.size());
			log.debug(">buscarTodos() ---- contenido   " + hoteles);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return hoteles;
    }



    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection hoteles;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            hoteles = HibernateUtil.getSession()
                                    .createCriteria(Hotel.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + hoteles.size());
			log.debug(">buscarTodos() ---- contenido   " + hoteles);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return hoteles;
    }


    public Collection buscarPorEjemplo(Hotel hotel)
            throws ExcepcionInfraestructura {


        Collection hoteles;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Hotel.class);
            hoteles = criteria.add(Example.create(hotel)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return hoteles;
    }


    public void hazPersistente(Hotel hotel)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(hotel)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(hotel);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Hotel hotel)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(hotel)");
        }

        try {
            HibernateUtil.getSession().delete(hotel);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeHotel(String nombreHotel)
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

            String hql = "select nombre from Hotel where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreHotel);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreHotel);
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

    public boolean modificar( Hotel hotel ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(estado)");

        }

        try {

            System.out.println(hotel.toString());

            HibernateUtil.getSession().saveOrUpdate(hotel);

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
    public Collection buscarImagen(String nombreHotel)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Hotel where nombre = '"+nombreHotel+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreHotel);
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

	public Collection buscarHotel(String nombreHotel)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Hotel where nombre like '"+nombreHotel+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreHotel);
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

    public Collection buscarEstado(String nombreHotel)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Hotel where nombre = '"+nombreHotel+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreHotel);
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
