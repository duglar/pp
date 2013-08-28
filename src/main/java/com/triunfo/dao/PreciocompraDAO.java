/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpreciocompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */

@Local
public interface PreciocompraDAO {
    public Boolean insertarpreciocompra(Tblpreciocompra Tblpreciocompra);
    public Boolean actualizarpreciocompra(Tblpreciocompra Tblpreciocompra);
    public Boolean eliminarpreciocompra(Tblpreciocompra Tblpreciocompra);
    public List<Tblpreciocompra> buscarpreciocompra();   
}
