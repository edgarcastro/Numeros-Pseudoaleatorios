/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios.modelo;

import java.util.List;

/**
 *
 * @author Edgar Castro
 * @version 0.1
 */
public interface Generador {
    /**
     * Método para generar siguiente número aleatorio.
     * @return Siguiente número aleatorio.
     */
    public Integer siguiente();
    /**
     * Método para generar siguiente número aleatorio entre 0 y 1.
     * @return Siguiente número aleatorio entre 0 y 1.
     */
    public Double siguienteAlt();
    /**
     * Método para generar un número especifico de números aleatorios.
     * @param cantidad El parámetro indica la cantidad de números a generar.
     * @return Una lista con números generados aleatorios.
     */
    public List<Integer> generar(Integer cantidad);
    /**
     * Método para generar un número especifico de números aleatorios entre 0 y 1.
     * @param cantidad El parámetro indica la cantidad de números a generar.
     * @return Una lista con números generados aleatorios entre 0 y 1.
     */
    public List<Double> generarAlt(Integer cantidad);
}
