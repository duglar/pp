/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.PersonaDAO;
import com.triunfo.entidades.Tblpersona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class PersonaDAOIMPL  implements PersonaDAO{
    
    @Override
    public Boolean insertarpersona(Tblpersona Tblpersona) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarpersona persona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarpersona(Tblpersona Tblpersona  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarpersona persona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarpersona(Tblpersona Tblpersona) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblpersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarpersona persona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblpersona> buscarpersona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblpersona> personas = new ArrayList<Tblpersona>();
        try {
            Query q = session.createQuery("from Tblpersona");
           personas = q.list();
        } catch (Exception e) {
            personas = null;
            System.err.println("Error al buscar buscarpersona: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return personas;
    
    }
    
    
}
