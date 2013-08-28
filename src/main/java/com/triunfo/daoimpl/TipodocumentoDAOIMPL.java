/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.dao.TipodocumentoDAO;
import com.triunfo.entidades.Tbltipodocumento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class TipodocumentoDAOIMPL implements TipodocumentoDAO {
     @Override
    public Boolean insertartipodocumento(Tbltipodocumento Tbltipodocumento) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertartipodocumento tipodocumento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizartipodocumento(Tbltipodocumento  Tbltipodocumento  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizartipodocumento tipodocumento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminartipodocumento(Tbltipodocumento Tbltipodocumento ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tbltipodocumento);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminartipodocumento tipodocumento " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tbltipodocumento>  buscartipodocumento() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbltipodocumento> tipodocumentos = new ArrayList<Tbltipodocumento>();
        try {
            Query q = session.createQuery("from Tbltipodocumento");
           tipodocumentos= q.list();
        } catch (Exception e) {
            tipodocumentos = null;
            System.err.println("Error al buscar buscartipodocumento: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return tipodocumentos;
    
    }
      
}
