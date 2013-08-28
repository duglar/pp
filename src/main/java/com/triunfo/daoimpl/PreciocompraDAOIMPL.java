/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.PreciocompraDAO;
import com.triunfo.entidades.Tblpreciocompra;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class PreciocompraDAOIMPL  implements PreciocompraDAO{
    
    @Override
    public Boolean insertarpreciocompra(Tblpreciocompra Tblpreciocompra) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarpreciocompra preciocompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarpreciocompra(Tblpreciocompra Tblpreciocompra  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarpreciocompra preciocompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarpreciocompra(Tblpreciocompra Tblpreciocompra) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblpreciocompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarpreciocompra preciocompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblpreciocompra> buscarpreciocompra() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpreciocompra> preciocompras = new ArrayList<Tblpreciocompra>();
        try {
            Query q = session.createQuery("from Tblpreciocompra");
           preciocompras = q.list();
        } catch (Exception e) {
            preciocompras = null;
            System.err.println("Error al buscar buscarpreciocompra: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return preciocompras;
    
    }
    
    
}
