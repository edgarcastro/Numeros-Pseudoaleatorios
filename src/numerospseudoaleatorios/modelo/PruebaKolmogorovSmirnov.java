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
public class PruebaKolmogorovSmirnov implements Prueba{

    @Override
    public Boolean probarNumeros(List<Integer> numeros) {
        List<Integer> ordenados = new ArrayList<>();
        Integer menor = numeros.get(0);
        while(numeros.size()>0){
            for (int i = 0; i < numeros.size(); i++) {
                if(numeros.get(i) < menor){
                    menor = numeros.get(i);
                    numeros.remove(numeros.get(i));
                    ordenados.add(menor);
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
