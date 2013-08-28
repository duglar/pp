/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.UsuarioDAO;
import com.triunfo.entidades.Tblusuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class UsuarioDAOIMPL implements UsuarioDAO {
  @Override
    public Boolean insertarusuario(Tblusuario Tblusuario) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarusuario usuario " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarusuario(Tblusuario Tblusuario  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarusuario usuario " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarusuario(Tblusuario Tblusuario ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblusuario);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarusuario usuario " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblusuario>  buscarusuario() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblusuario> usuarios = new ArrayList<Tblusuario>();
        try {
            Query q = session.createQuery("from unidad");
            usuarios= q.list();
        } catch (Exception e) {
             usuarios = null;
            System.err.println("Error al buscar buscarusuario: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return  usuarios;
    
    }     
}
