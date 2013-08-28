/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblcompra;
import com.triunfo.dao.CompraDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Stateless
public class CompraDAOIMPL  implements CompraDAO  {
 
    @Override
    public Boolean insertarCompra(Tblcompra Tblcompra) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblcompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarcompra Compra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarCompra(Tblcompra tblcompra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblcompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarcompra compra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarCompra(Tblcompra tblcompra) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblcompra);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarcompra compra " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblcompra> buscarCompra() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblcompra> compras = new ArrayList<Tblcompra>();
        try {
            Query q = session.createQuery("from Tblcompra");
            compras = q.list();
        } catch (Exception e) {
            compras = null;
            System.err.println("Error al buscar buscarcompra: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return compras;
    
    }

   
    
}
