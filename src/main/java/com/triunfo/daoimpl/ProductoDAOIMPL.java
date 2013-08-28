/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblproducto;
import com.triunfo.dao.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class ProductoDAOIMPL implements ProductoDAO {
   @Override
    public Boolean insertarproducto(Tblproducto Tblproducto) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarproducto producto " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarproducto(Tblproducto Tblproducto  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarproducto producto " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarproducto(Tblproducto Tblproducto) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblproducto);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarproducto producto " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblproducto> buscarproducto() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblproducto> productos = new ArrayList<Tblproducto>();
        try {
            Query q = session.createQuery("from Tblproducto");
           productos = q.list();
        } catch (Exception e) {
            productos = null;
            System.err.println("Error al buscar buscarproducto: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return productos;
    
    }
      
}
