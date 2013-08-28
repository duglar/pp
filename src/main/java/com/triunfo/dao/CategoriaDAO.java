/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tblcategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR 
 */
@Local
public interface CategoriaDAO {
    public Boolean insertarCategoria(Tblcategoria tblcategoria);
    public Boolean actualizarCategoria(Tblcategoria tblcategoria);
    public Boolean eliminarCategoria(Tblcategoria tblcategoria);
   public List<Tblcategoria> buscarCategoria();    

   

    

    
}
