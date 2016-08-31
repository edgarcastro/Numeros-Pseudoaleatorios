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
public class PruebaFrecuencia implements Prueba{
    private int n; //numero de intervalos.
    private double chi;

    public PruebaFrecuencia(int n, double chi) {
        this.n = n;
        this.chi = chi;
    }
    
    @Override
    public Boolean probarNumeros(List numeros) {
        Boolean aceptado = false;
        int N = numeros.size()/this.n;
        double FE = 1/(double)N;
        int contador;
        List<Integer> FO = new ArrayList<>();
        List<Double> intervalos = new ArrayList<>();
        intervalos.add(0.0);
        intervalos.add(FE);
        for (int i = 1; i < n+1; i++) {
            intervalos.add(intervalos.get(i)+FE);
        }
        
        for (int i = 1; i < intervalos.size(); i++) {
            contador = 0;
            for (int j = 0; j < numeros.size(); j++) {
                if((double)numeros.get(j) >= intervalos.get(i-1)  && (double)numeros.get(j) < intervalos.get(i)){
                    contador++;
                }
            }
            FO.add(contador);
        }
        Double x = 0.0;
        for (int i = 0; i < FO.size(); i++) {
            x = x + ((Math.pow((FO.get(i)-N), 2))/N);
        }
        
        
        if(x < this.chi){
            aceptado = true;
        }
        System.out.println("Aceptado? "+aceptado);
        return aceptado;
    }  
}
