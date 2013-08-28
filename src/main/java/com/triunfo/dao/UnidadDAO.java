/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblunidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface UnidadDAO {
     public Boolean insertarUnidad(Tblunidad Tblunidad );
    public Boolean actualizarUnidad(Tblunidad Tblunidad);
    public Boolean eliminarUnidad(Tblunidad Tblunidad);
    public List<Tblunidad> buscarUnidad(); 
}
