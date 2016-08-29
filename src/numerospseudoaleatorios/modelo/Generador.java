/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios.modelo;

import java.util.List;

/**
 *
 * @author edgar
 */
public interface Generador {
    public List<Integer> generar(Integer cantidad);
    public List<Double> generarAlt(Integer cantidad);
}
