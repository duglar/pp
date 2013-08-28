/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface VentaDAO {
    public Boolean insertarventa(Tblventa Tblventa );
    public Boolean actualizarventa(Tblventa Tblventa);
    public Boolean  eliminarventa(Tblventa Tblventa);
    public List<Tblventa> buscarventa(); 
}
