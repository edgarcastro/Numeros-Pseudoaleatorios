package numerospseudoaleatorios.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgar
 */
public class CongruencialMixto implements Generador{
    /* Esta descrito de la forma: 
    x[n+1] = ( a*x[n] +  c ) * mod m
    ((this.a*this.x)+this.c)*/
    private Integer a;
    private Integer c;
    private Integer m;
    private Integer x;
    

    public CongruencialMixto(Integer a, Integer c, Integer m, Integer x) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.x = x;
    }
    
    @Override
    public List<Integer> generar(Integer cantidad){
        List<Integer> numeros = new ArrayList<>();
        numeros.add(((this.a*this.x)+this.c) % this.m);
        for (int i = 0; i < cantidad; i++) {
            numeros.add((((this.a*numeros.get(i))+this.c)%this.m));
        }
        this.x = numeros.get(numeros.size()-1);
        return numeros;
    }
    
    @Override
    public List<Double> generarAlt(Integer cantidad) {
        List<Integer> numeros = generar(cantidad);
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add((double)numeros.get(i)/this.m);
        }
        return lista;
    }

    @Override
    public Integer siguiente() {
        this.x = (((this.a*this.x)+this.c) % this.m);
        return this.x;
    }

    @Override
    public Double siguienteAlt() {
        this.x = (((this.a*this.x)+this.c) % this.m);
        return (double) this.x/this.m;
    }
    
}
