/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbltipodocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface TipodocumentoDAO {
     public Boolean insertartipodocumento(Tbltipodocumento Tbltipodocumento);
    public Boolean actualizartipodocumento(Tbltipodocumento Tbltipodocumento);
    public Boolean eliminartipodocumento(Tbltipodocumento Tbltipodocumento);
    public List<Tbltipodocumento> buscartipodocumento();  
}
