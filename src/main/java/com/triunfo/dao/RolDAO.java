/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblrol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface RolDAO {
  public Boolean insertarRol(Tblrol Tblrol);
    public Boolean actualizarRol(Tblrol Tblrol);
    public Boolean eliminarRol(Tblrol Tblrol);
    public List<Tblrol> buscarRol();   
}
