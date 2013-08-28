/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triunfo.dao;

import com.triunfo.entidades.Tbldepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DUGLAR ZEMANATE
 */
@Local
public interface DepartamentoDAO {
    public Boolean insertarDepartamento(Tbldepartamento tbldepartamento);
    public Boolean actualizarDepartamento(Tbldepartamento tbldepartamento);
    public Boolean eliminarDepartamento(Tbldepartamento tbldepartamento);
    public List<Tbldepartamento> buscarDepartamento(); 
}
