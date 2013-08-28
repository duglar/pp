/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblsexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface SexoDAO {
    public Boolean insertarSexo(Tblsexo Tblsexo);
    public Boolean actualizarSexo(Tblsexo Tblsexo);
    public Boolean eliminarSexo(Tblsexo Tblsexo);
    public List<Tblsexo> buscarSexo();   
}
