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
    
    public static final Integer SUMA = 1;
    public static final Integer RESTA = 2;
    public static final Integer PRODUCTO = 3;
    public static final Integer DIVISION = 4;

    public Fibonacci(List<Integer> semillas, Integer m, Integer operacion) {
        this.semillas = semillas;
        this.m = m;
        this.operacion = operacion;
    }
    
    @Override
    public List<Integer> generar(Integer cantidad) {
        for (int i = this.semillas.size(); i < cantidad; i++) {
            siguiente();
        }
        return this.semillas;
    }

    @Override
    public List<Double> generarAlt(Integer cantidad) {
        generar(cantidad);
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add((double)this.semillas.get(i)/this.m);
        }
        return lista;
    }

    @Override
    public Integer siguiente() {
        switch (operacion) {
            case 1:
                this.semillas.add((this.semillas.get(this.semillas.size()-2) + this.semillas.get(this.semillas.size()-1)) % this.m);
                break;
            case 2:
                this.semillas.add((this.semillas.get(this.semillas.size()-2) - this.semillas.get(this.semillas.size()-1)) % this.m);
                break;
            case 3:
                this.semillas.add((this.semillas.get(this.semillas.size()-2) * this.semillas.get(this.semillas.size()-1)) % this.m);
                break;
            case 4:
                this.semillas.add((this.semillas.get(this.semillas.size()-2) / this.semillas.get(this.semillas.size()-1)) % this.m);
                break;
        }
        return this.semillas.get(this.semillas.size()-1);
    }

    @Override
    public Double siguienteAlt() {
        return (double) siguiente()/this.m;
    }
    
}
