/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.CategoriaDAO;

import com.triunfo.entidades.Tblcategoria;
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
public class CategoriaDAOIMPL implements CategoriaDAO {
     /**
     *
     * @param Tblcategoria
     * @return
     */
    @Override
    public Boolean insertarCategoria(Tblcategoria Tblcategoria) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarcategoria Categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarCategoria(Tblcategoria tblcategoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarcategoria categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarCategoria(Tblcategoria tblcategoria) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(tblcategoria);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarCategoria Categoria " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblcategoria> buscarCategoria() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblcategoria> categorias = new ArrayList<Tblcategoria>();
        try {
            Query q = session.createQuery("from Tblcategoria");
           categorias = q.list();
        } catch (Exception e) {
           categorias = null;
            System.err.println("Error al buscar buscarCaregria: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return categorias ;
    
    }

   
    
    
    
    
    
}
