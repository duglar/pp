/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbldocumento;
import com.triunfo.dao.DocumentoDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class DoccumentoDAOIMPL  implements DocumentoDAO{
    @Override
    public Boolean insertardocumento(Tbldocumento Tbldocumento) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertardocumento documento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizardocumento(Tbldocumento  Tbldocumento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizardocumento documento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminardocumento(Tbldocumento Tbldocumento) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tbldocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminardocumento   documento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tbldocumento> buscardocumento() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbldocumento> documentos = new ArrayList<Tbldocumento>();
        try {
            Query q = session.createQuery("from Tbldocumento");
            documentos = q.list();
        } catch (Exception e) {
            documentos = null;
            System.err.println("Error al buscar buscardocumento: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return documentos;
    
    }
    
    
}
