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
 * @author edgar
 */
public class CongruencialCuadratico implements Generador{
    /* Esta descrito de la forma: 
    x[n+1] = (d*x[n]^2 + a*x[n] +  c ) * mod m
    ((this.d*Math.pow(this.x,2))+(this.a*this.x)+this.c)*/
    private Integer d;
    private Integer a;
    private Integer c;
    private Integer m;
    private Integer x;

    public CongruencialCuadratico(Integer d, Integer a, Integer c, Integer m, Integer x) {
        this.d = d;
        this.a = a;
        this.c = c;
        this.m = m;
        this.x = x;
    }

    @Override
    public List<Integer> generar(Integer cantidad) {
        List<Integer> numeros = new ArrayList<>();
        Integer potencia = (int)Math.pow(this.x, 2);
        numeros.add(((this.d*potencia)+(this.a*this.x)+this.c) % this.m);
        for (int i = 0; i < cantidad; i++) {
            potencia = (int)Math.pow(numeros.get(i), 2);
            numeros.add((((this.d*potencia)+(this.a*numeros.get(i))+this.c)%this.m));
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
