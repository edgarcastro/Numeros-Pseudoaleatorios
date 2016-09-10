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
    private List<Integer> semillas;
    private Integer m;
    private Integer operacion;
    private Integer x0;
    private Integer x1;
    
    public static Integer SUMA = 1;
    public static Integer RESTA = 2;
    public static Integer PRODUCTO = 3;
    public static Integer DIVISION = 4;

    public Fibonacci(List<Integer> semillas, Integer m, Integer operacion) {
        this.semillas = semillas;
        this.m = m;
        this.operacion = operacion;
    }
    
    @Override
    public List<Integer> generar(Integer cantidad) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < this.semillas.size(); i++) {
            numeros.add(this.semillas.get(i));
        }
        switch (operacion) {
            case 1:
                for (int i = numeros.size()-1; i < cantidad; i++) {
                numeros.add((numeros.get(i-1) + numeros.get(i)) % this.m);
                this.x0 = numeros.get(numeros.size()-2);
                this.x1 = numeros.get(numeros.size()-1);
                }
                break;
            case 2:
                for (int i = numeros.size()-1; i < cantidad; i++) {
                numeros.add((numeros.get(i-1) - numeros.get(i)) % this.m);
                this.x0 = numeros.get(numeros.size()-2);
                this.x1 = numeros.get(numeros.size()-1);
                }
                break;
            case 3:
                for (int i = numeros.size()-1; i < cantidad; i++) {
                numeros.add((numeros.get(i-1) * numeros.get(i)) % this.m);
                this.x0 = numeros.get(numeros.size()-2);
                this.x1 = numeros.get(numeros.size()-1);
                }
                break;
            case 4:
                for (int i = numeros.size()-1; i < cantidad; i++) {
                numeros.add((numeros.get(i-1) / numeros.get(i)) % this.m);
                this.x0 = numeros.get(numeros.size()-2);
                this.x1 = numeros.get(numeros.size()-1);
                }
                break;
        }
        return numeros;
    }

    @Override
    public List<Double> generarAlt(Integer cantidad) {
        List<Integer> numeros = generar(cantidad);
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add((double)numeros.get(i)/this.m);
        }
        this.x0 = numeros.get(numeros.size()-1);
        return lista;
    }

    @Override
    public Integer siguiente() {
        Integer c = 0;
        switch (operacion) {
            case 1:
                c = this.x1;
                this.x1 = (this.x0 + this.x1) % this.m;
                this.x0 = c;
                break;
            case 2:
                c = this.x1;
                this.x1 = (this.x0 - this.x1) % this.m;
                this.x0 = c;
                break;
            case 3:
                c = this.x1;
                this.x1 = (this.x0 * this.x1) % this.m;
                this.x0 = c;
                break;
            case 4:
                 c = this.x1;
                this.x1 = (this.x0 / this.x1) % this.m;
                this.x0 = c;
                break;
        }
        return this.x1;
    }

    @Override
    public Double siguienteAlt() {
        Integer c = 0;
        switch (operacion) {
            case 1:
                c = this.x1;
                this.x1 = (this.x0 + this.x1) % this.m;
                this.x0 = c;
                break;
            case 2:
                c = this.x1;
                this.x1 = (this.x0 - this.x1) % this.m;
                this.x0 = c;
                break;
            case 3:
                c = this.x1;
                this.x1 = (this.x0 * this.x1) % this.m;
                this.x0 = c;
                break;
            case 4:
                 c = this.x1;
                this.x1 = (this.x0 / this.x1) % this.m;
                this.x0 = c;
                break;
        }
        return (double) this.x1/this.m;
    }
    
}
