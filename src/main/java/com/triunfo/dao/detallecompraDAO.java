/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldetallecompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface detallecompraDAO {
    public Boolean insertardatallecompra(Tbldetallecompra tbldetallecompra);
    public Boolean actualizardetallecompra(Tbldetallecompra tbldetallecompra);
    public Boolean eliminardetallecompra(Tbldetallecompra tbldetallecompra);
    public List<Tbldetallecompra> buscardetallecompra(); 
}
