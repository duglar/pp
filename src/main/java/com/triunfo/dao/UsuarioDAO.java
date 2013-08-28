/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblusuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface UsuarioDAO {
    
    public Boolean insertarusuario(Tblusuario Tblusuario );
    public Boolean actualizarusuario(Tblusuario Tblusuario);
    public Boolean eliminarusuario(Tblusuario Tblusuario);
    public List<Tblusuario> buscarusuario(); 
}
