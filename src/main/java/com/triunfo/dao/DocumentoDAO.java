/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface DocumentoDAO {
     public Boolean insertardocumento(Tbldocumento Tbldocumento);
    public Boolean actualizardocumento(Tbldocumento Tbldocumento);
    public Boolean eliminardocumento(Tbldocumento Tbldocumento);
    public List<Tbldocumento> buscardocumento(); 
}
