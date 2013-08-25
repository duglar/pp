/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.BarrioDAO;
import com.triunfo.entidades.Tblbarrio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author david
 */

@Stateless
public class BarrioDAOIMPL implements BarrioDAO{

    @Override
    public Boolean insertarBarrio(Tblbarrio tblbarrio) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(tblbarrio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarBarrio Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

    @Override
    public Boolean actualizarBarrio(Tblbarrio tblbarrio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblbarrio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarBarrio Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public Boolean eliminarBarrio(Tblbarrio tblbarrio) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblbarrio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarBarrio Barrio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

    @Override
    public List<Tblbarrio> buscarBarrios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblbarrio> barrios = new ArrayList<Tblbarrio>();
        try {
            Query q = session.createQuery("from Tblbarrio");
            barrios = q.list();
        } catch (Exception e) {
            barrios = null;
            System.err.println("Error al buscar buscarBarrios: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return barrios;
    }

   
    
}
