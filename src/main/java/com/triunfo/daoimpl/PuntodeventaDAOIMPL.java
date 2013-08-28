/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblpuntodeventa;
import com.triunfo.dao.PuntodeventaDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class PuntodeventaDAOIMPL  implements PuntodeventaDAO{
    
     @Override
    public Boolean insertarPuntodeventa(Tblpuntodeventa Tblpuntodeventa) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblpuntodeventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarpuntodeventa puntodeventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarPuntodeventa(Tblpuntodeventa Tblpuntodeventa  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblpuntodeventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarpuntodeventa puntodeventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarPuntodeventa(Tblpuntodeventa Tblpuntodeventa ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblpuntodeventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarpuntodeventa puntodeventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblpuntodeventa>  buscarPuntodeventa() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpuntodeventa> puntosdeventa = new ArrayList<Tblpuntodeventa>();
        try {
            Query q = session.createQuery("from Tblpuntodeventa");
           puntosdeventa= q.list();
        } catch (Exception e) {
            puntosdeventa= null;
            System.err.println("Error al buscar buscarpunodeventa: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return puntosdeventa;
    
    }
      
    
}
