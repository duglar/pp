/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbltipopersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface TipopersonaDAO {
    public Boolean insertartipopersona(Tbltipopersona Tbltipopersona );
    public Boolean actualizartipopersona(Tbltipopersona Tbltipopersona);
    public Boolean eliminartipopersona(Tbltipopersona Tbltipopersona);
    public List<Tbltipopersona> buscartipopersona();  
}
