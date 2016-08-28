/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgarcastro
 */
public class Fibonacci implements Generador{
    private Integer n0;
    private Integer n1;
    private Integer m;
    private Integer s;
    private Integer r;
    private Integer operacion;
    
    public static Integer SUMA = 1;
    public static Integer RESTA = 2;
    public static Integer PRODUCTO = 3;
    public static Integer DIVISION = 4;

    public Fibonacci(Integer N0, Integer N1, Integer m, Integer s, Integer r, Integer operacion) {
        this.n0 = N0;
        this.n1 = N1;
        this.m = m;
        this.s = s;
        this.r = r;
        this.operacion = operacion;
    }
    
    

    @Override
    public List<Integer> generar(Integer cantidad) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(this.n0);
        numeros.add(this.n1);
        switch (operacion) {
            case 1:
                for (int i = numeros.size(); i < cantidad; i++) {
                numeros.add((numeros.get(i-this.s) + numeros.get(i-this.r)) % this.m);
                }
                break;
            case 2:
                for (int i = numeros.size(); i < cantidad; i++) {
                numeros.add((numeros.get(i-this.s) - numeros.get(i-this.r)) % this.m);
                }
                break;
            case 3:
                for (int i = numeros.size(); i < cantidad; i++) {
                numeros.add((numeros.get(i-this.s) * numeros.get(i-this.r)) % this.m);
                }
                break;
            case 4:
                for (int i = numeros.size(); i < cantidad; i++) {
                numeros.add((numeros.get(i-this.s) / numeros.get(i-this.r)) % this.m);
                }
                break;
        }
        return numeros;
    }

    @Override
    public List<Integer> generarAlt(Integer cantidad) {
         List<Integer> numeros = generar(cantidad);
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(numeros.get(i)/this.m);
        }
        return lista;
    }
    
}
