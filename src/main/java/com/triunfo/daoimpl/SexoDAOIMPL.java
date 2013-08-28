/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblsexo;
import com.triunfo.dao.SexoDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class SexoDAOIMPL  implements SexoDAO{
    @Override
    public Boolean insertarSexo(Tblsexo Tblsexo) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarsexo sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarSexo(Tblsexo Tblsexo  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarSexo Sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarSexo(Tblsexo Tblsexo ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblsexo);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarSexo Sexo " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblsexo>  buscarSexo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblsexo> sexos = new ArrayList<Tblsexo>();
        try {
            Query q = session.createQuery("from Tblsexo");
           sexos= q.list();
        } catch (Exception e) {
            sexos= null;
            System.err.println("Error al buscar buscarSexo: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return sexos;
    
    }
      
}
