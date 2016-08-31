/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edgarcastro
 */
public class PruebaKolmogorovSmirnov implements Prueba{

    @Override
    public Boolean probarNumeros(List numeros) {
        Boolean aceptado = false;
        Collections.sort(numeros);
        List<Double> Fn = new ArrayList<>();
        Double Xn;
        Double Xi;
        for (int i = 0; i < numeros.size(); i++) {
            Xn = (double)(i+1)/numeros.size();
            Xi = (double) numeros.get(i);
            Fn.add((double)Math.abs(Xn-Xi));
        }
        Double Dn = Fn.get(0);
        for (int i = 0; i < Fn.size(); i++) {
            if(Fn.get(i) > Dn)
                Dn = Fn.get(i);
        }
        if(Dn < (1.36/Math.sqrt((double)numeros.size()))){
            aceptado = true;
        }
        System.out.println("Aceptado? "+aceptado);
        return aceptado;
    }
    
}
