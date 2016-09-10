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
public class Green implements Generador{
    private List<Integer> semillas;
    private Integer m;
    private Integer k;
    private Integer operacion;
    
    public static Integer SUMA = 1;
    public static Integer RESTA = 2;
    public static Integer PRODUCTO = 3;
    public static Integer DIVISION = 4;
    
     public Green(List<Integer> semillas, Integer m, Integer k, Integer operacion) {
        this.semillas = semillas;
        this.m = m;
        this.k = k;
        this.operacion = operacion;
    }

    @Override
    public Integer siguiente() {
        switch (operacion) {
            case 1:
                this.semillas.add((this.semillas.get(this.semillas.size()-1) + this.semillas.get(this.semillas.size()-1-this.k)) % this.m);
                break;
            case 2:
                this.semillas.add((this.semillas.get(this.semillas.size()-1) - this.semillas.get(this.semillas.size()-1-this.k)) % this.m);
                break;
            case 3:
                this.semillas.add((this.semillas.get(this.semillas.size()-1) * this.semillas.get(this.semillas.size()-1-this.k)) % this.m);
                break;
            case 4:
                this.semillas.add((this.semillas.get(this.semillas.size()-1) / this.semillas.get(this.semillas.size()-1-this.k)) % this.m);
                break;
        }
        return this.semillas.get(semillas.size()-1);
    }

    @Override
    public Double siguienteAlt() {
        return (double) siguiente()/this.m;
    }

    @Override
    public List<Integer> generar(Integer cantidad) {
       switch (operacion) {
            case 1:
                for (int i = this.semillas.size()-1; i < cantidad; i++) {
                this.semillas.add((this.semillas.get(i) + this.semillas.get(i-this.k)) % this.m);
                }
                break;
            case 2:
                for (int i = this.semillas.size()-1; i < cantidad; i++) {
                this.semillas.add((this.semillas.get(i) - this.semillas.get(i-this.k)) % this.m);
                }
                break;
            case 3:
                for (int i = this.semillas.size()-1; i < cantidad; i++) {
                this.semillas.add((this.semillas.get(i) * this.semillas.get(i-this.k)) % this.m);
                }
                break;
            case 4:
                for (int i = this.semillas.size()-1; i < cantidad; i++) {
                this.semillas.add((this.semillas.get(i) / this.semillas.get(i-this.k)) % this.m);
                }
                break;
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
    
}
