/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.daoimpl;

import com.triunfa.hibernate.HibernateUtil;
import com.triunfo.entidades.Tblproveedor;
import com.triunfo.dao.ProveedorDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUGLAR ZEMANATE
 */
public class ProveedorDAOIMPL  implements ProveedorDAO {
     @Override
    public Boolean insertarProveedor(Tblproveedor Tblproveedor) {          
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.save(Tblproveedor);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en insertarproveedor proveedor " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
       
    }

        @Override
    public Boolean actualizarProveedor(Tblproveedor Tblproveedor  ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.update(Tblproveedor);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en actualizarproveedor proveedor " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

        @Override
    public Boolean eliminarProveedor(Tblproveedor Tblproveedor ) {
             Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;        
        try {
            session.beginTransaction();          
            session.delete(Tblproveedor);
            session.flush();
            session.beginTransaction().commit();
            resultado = true;
        } catch (Exception e) {
            System.err.println("Error en eliminarproveedor proveedor " + e.getMessage());
            session.beginTransaction().rollback();
            resultado = false;
        } finally {
            session.close();
        }
        return resultado;
    }

      @Override
    public List<Tblproveedor>  buscarProveedor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tblproveedor> proveedores = new ArrayList<Tblproveedor>();
        try {
            Query q = session.createQuery("from Tblproveedores");
           proveedores = q.list();
        } catch (Exception e) {
            proveedores= null;
            System.err.println("Error al buscar buscarproveedor: " + e.getMessage());
            session.beginTransaction().rollback();
        } finally {
            session.close();
        }

        return proveedores;
    
    }
      
}
