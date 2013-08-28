/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tbltipopersona;
import com.triunfo.dao.TipopersonaDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class TipopersonaDAOIMPL  implements TipopersonaDAO{
  @Override
    public Boolean insertartipopersona(Tbltipopersona Tbltipopersona) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tbltipopersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertartipopersona tipopersona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizartipopersona(Tbltipopersona  Tbltipopersona  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tbltipopersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizartipersona tipopersona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminartipopersona(Tbltipopersona Tbltipopersona ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tbltipopersona);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminartipersona tipopersona " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tbltipopersona>  buscartipopersona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tbltipopersona> tipopersonas = new ArrayList<Tbltipopersona>();
        try {
            Query q = session.createQuery("from tipopersonas");
           tipopersonas= q.list();
        } catch (Exception e) {
            tipopersonas = null;
            System.err.println("Error al buscar buscartipopersona: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return tipopersonas;
    
    }  
}
