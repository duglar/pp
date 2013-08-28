/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblpais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface PaisDAO {
     public Boolean insertarpais(Tblpais Tblpais);
    public Boolean actualizarpais(Tblpais Tblpais);
    public Boolean eliminarpais(Tblpais Tblpais);
    public List<Tblpais> buscarpais(); 
    
}
