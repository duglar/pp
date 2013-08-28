/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblproveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface ProveedorDAO {
   public Boolean insertarProveedor(Tblproveedor Tblproveedor);
    public Boolean actualizarProveedor(Tblproveedor Tblproveedor);
    public Boolean eliminarProveedor(Tblproveedor Tblproveedor);
    public List<Tblproveedor> buscarProveedor(); 
    } 

