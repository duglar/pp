/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblmunicipio;
import com.triunfo.dao.MunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class MunicipioDAOIMPL  implements MunicipioDAO{
    
    @Override
    public Boolean insertarmunimipio(Tblmunicipio Tblmunicipio) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblmunicipio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarmunicipio municipio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarmunicipio(Tblmunicipio Tblmunicipio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblmunicipio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarmunicipio municipio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarmunicipio(Tblmunicipio Tblmunicipio) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblmunicipio);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarmunicipio  municipio " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblmunicipio> buscarmucinipio() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblmunicipio> municipios = new ArrayList<Tblmunicipio>();
        try {
            Query q = session.createQuery("from Tblmunicipio");
            municipios = q.list();
        } catch (Exception e) {
            municipios = null;
            System.err.println("Error al buscar buscarmucnipio: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return municipios;
    
    }
    
    
}
