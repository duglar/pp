/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldetallecompra;
import com.triunfo.dao.detallecompraDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class DetallecompraDAOIMPL  implements  detallecompraDAO{
    
    
    
    @Override
    public Boolean insertardatallecompra(Tbldetallecompra Tbldetallecompra) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertardatallecompra detallecompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizardetallecompra(Tbldetallecompra  Tbldetallecompra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizardetallecompra detallecompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminardetallecompra(Tbldetallecompra Tbldetallecompra) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tbldetallecompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarTbldetallecompra   detallecompra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tbldetallecompra> buscardetallecompra() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldetallecompra> detallecompras = new ArrayList<Tbldetallecompra>();
        try {
            Query q = session.createQuery("from Tbldetallecompra");
            detallecompras = q.list();
        } catch (Exception e) {
            detallecompras = null;
            System.err.println("Error al buscar buscardetallecompra: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return detallecompras;
    
    }

   
    
}
