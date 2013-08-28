/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblunidad;
import com.triunfo.dao.UnidadDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class UnidadDAOIMPL implements UnidadDAO{
    @Override
    public Boolean insertarUnidad(Tblunidad Tblunidad) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarunidad unidad " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarUnidad(Tblunidad Tblunidad  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarunidad unidad " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarUnidad(Tblunidad Tblunidad ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblunidad);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarunidad unidad " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblunidad>  buscarUnidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblunidad> unidades = new ArrayList<Tblunidad>();
        try {
            Query q = session.createQuery("from unidad");
           unidades= q.list();
        } catch (Exception e) {
            unidades = null;
            System.err.println("Error al buscar buscarunidad: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return unidades;
    
    }  
}
