/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblmarca;
import com.triunfo.dao.MarcaDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class MarcaDAOIMPL  implements MarcaDAO{
    
     @Override
    public Boolean insertarmarca(Tblmarca Tblmarca) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarmarca marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarmarca(Tblmarca  Tblmarca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarmarca marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarmarca(Tblmarca Tblmarca) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblmarca);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarmarca  marca " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblmarca> buscarmarca() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblmarca> marcas = new ArrayList<Tblmarca>();
        try {
            Query q = session.createQuery("from Tblmarca");
            marcas = q.list();
        } catch (Exception e) {
            marcas = null;
            System.err.println("Error al buscar buscarmarca: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return marcas;
    
    }
    
    
    
}
