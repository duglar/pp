/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldetalleventa;
import com.triunfo.dao.DetalleventaDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class DetalleventaDAOIMPL  implements DetalleventaDAO{
    @Override
    public Boolean insertardetalleventa(Tbldetalleventa Tbldetalleventa) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertardatalleventa detalleventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizardetalleventa(Tbldetalleventa  Tbldetalleventa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizardetalleventa detalleventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminardetalleventa(Tbldetalleventa Tbldetalleventa) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tbldetalleventa);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarTbldetalleventa   detalleventa " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tbldetalleventa> buscardetalleventa() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldetalleventa> detalleventas = new ArrayList<Tbldetalleventa>();
        try {
            Query q = session.createQuery("from Tbldetalleventas");
            detalleventas = q.list();
        } catch (Exception e) {
            detalleventas = null;
            System.err.println("Error al buscar buscardetalleventas: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return detalleventas;
    
    }

    
    
}
