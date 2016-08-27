/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios;

import numerospseudoaleatorios.modelo.CongruencialCuadratico;
import numerospseudoaleatorios.modelo.CongruencialMixto;
import numerospseudoaleatorios.modelo.CongruencialMultiplicativo;
import numerospseudoaleatorios.modelo.Fibonacci;
import numerospseudoaleatorios.modelo.Generador;

/**
 *
 * @author edgar
 */
public class NumerosPseusoaleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generador g;
        //g = new CongruencialMixto(24, 13, 23, 3);
        //g = new CongruencialMultiplicativo(15, 101, 6);
        //g =  new CongruencialCuadratico(26, 27, 27, 8, 13);
        g = new Fibonacci(4, 11, 13, 1, 2, Fibonacci.PRODUCTO);
        System.out.println(""+g.generar(28).toString());
    }
    
}
