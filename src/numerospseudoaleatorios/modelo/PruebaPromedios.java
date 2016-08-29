/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios.modelo;

import java.util.List;

/**
 *
 * @author edgarcastro
 */
public class PruebaPromedios implements Prueba{
    private static final Double Z = 1.96;

    @Override
    public Boolean probarNumeros(List numeros) {
        Boolean aceptado = false;
        Double media;
        Double z0;
        Double suma = 0.000000;
        for (int i = 0; i < numeros.size(); i++) {
            suma = suma + (double)numeros.get(i);
        }
        media = suma / numeros.size();
        System.out.println("Media: "+media);
        z0 = ((media - 0.5)*Math.sqrt(numeros.size()))/(Math.sqrt(0.08333));
        System.out.println("Zo :"+z0);
        if(z0 < Z)
            aceptado = true;
        System.out.println("Acepto? "+aceptado);
        return aceptado;
    }
    
}
