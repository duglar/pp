/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldetalleventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface DetalleventaDAO {
    public Boolean insertardetalleventa(Tbldetalleventa Tbldetalleventa);
    public Boolean actualizardetalleventa(Tbldetalleventa Tbldetalleventa);
    public Boolean eliminardetalleventa(Tbldetalleventa Tbldetalleventa);
    public List<Tbldetalleventa> buscardetalleventa(); 
}
