/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpuntodeventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface PuntodeventaDAO {
    public Boolean insertarPuntodeventa(Tblpuntodeventa Tblpuntodeventa);
    public Boolean actualizarPuntodeventa(Tblpuntodeventa Tblpuntodeventa);
    public Boolean eliminarPuntodeventa(Tblpuntodeventa Tblpuntodeventa);
    public List<Tblpuntodeventa> buscarPuntodeventa(); 
}
