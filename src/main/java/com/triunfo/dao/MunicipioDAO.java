/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblmunicipio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface MunicipioDAO {
    
    
     public Boolean insertarmunimipio(Tblmunicipio Tblmunicipio);
    public Boolean actualizarmunicipio(Tblmunicipio Tblmunicipio);
    public Boolean eliminarmunicipio(Tblmunicipio Tblmunicipio);
    public List<Tblmunicipio> buscarmucinipio(); 
    
}
