/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Poblacion {
    
    private final ArrayList<Cromosoma> cromosomas;
    //maimo, minimo y promedio de la funcion objetivo de la poblacion
    private  double maximo_fo;
    private  double minimo_fo;
    private  double promedio;
    private double total_fo;
    
    public Poblacion(ArrayList<Cromosoma> cromosomas) {
        this.cromosomas  = cromosomas;
        calcularValores();
    }

    private void calcularValores() {
        double max = cromosomas.get(0).evalFuncionObjetivo();
        double min = max;
        double sum = 0;
        for (Cromosoma cromosoma : cromosomas) {
            double aux = cromosoma.evalFuncionObjetivo();
            if (aux>max) {
                max = aux;
            } else if (aux<min) {
                min = aux;
            }
            sum+=aux;
        }
        this.maximo_fo = max;
        this.minimo_fo = min;
        this.promedio = sum / cromosomas.size();
        this.total_fo=sum;
    }

    StadisticUnit getStadisticUnit() {
        StadisticUnit stadisticUnit = new StadisticUnit();
        stadisticUnit.setMax_fo(maximo_fo);
        stadisticUnit.setMin_fo(minimo_fo);
        stadisticUnit.setPromedio(promedio);
        return stadisticUnit;
    }

    ArrayList<Cromosoma> generarNuevaPoblacion() 
    {
        ArrayList<Cromosoma> nuevos_cromosomas = new ArrayList<>();
        nuevos_cromosomas.addAll(getParElitista());
        // En vez de 10 ahora se utilizan 8 cromosomas. Porque dos pertenecen al grupo elitista.
        for (int i = 0; i < ((cromosomas.size()-2)/2); i++) {
            Cromosoma c1= seleccionarCromosoma();
            Cromosoma c2= seleccionarCromosoma();
            nuevos_cromosomas.add(mutacion(crossover(c1,c2).get(0)));
            nuevos_cromosomas.add(mutacion(crossover(c1,c2).get(1)));
        }
        return nuevos_cromosomas;
    }

    private Cromosoma seleccionarCromosoma() {
        double rnd = new Random().nextDouble();
        double acum =0;
        Cromosoma c= null;
        for (Cromosoma cromosoma : cromosomas) {
            acum += cromosoma.evalFuncionObjetivo()/this.total_fo;
            if(acum>=rnd)
            {
                c=cromosoma;
                break;
            }
        }
        return c;
       }

    private ArrayList<Cromosoma> crossover(Cromosoma c1, Cromosoma c2) {
        ArrayList<Cromosoma> hijos = new ArrayList<Cromosoma>();
        if (new Random().nextDouble()<=VariablesIniciales.PROBABILIDAD_CROSSOVER) 
        {
                  int corte = new Random().nextInt(c1.getGenes().length);

                  int[][] nuevos  = new int[2][30];
                  for(int i=0;i<=c1.getGenes().length-1;i++)
                    {
                       if(i<=corte)
                       {
                           nuevos[0][i]=c1.getGenes()[i];
                           nuevos[1][i]=c2.getGenes()[i];
                       }
                       else
                       {
                           nuevos[0][i]=c2.getGenes()[i];
                           nuevos[1][i]=c1.getGenes()[i];
                       }
                    }
      
                    hijos.add(new Cromosoma(nuevos[0]));
                    hijos.add(new Cromosoma(nuevos[1]));
        }
        else
        {
            hijos.add(c1);
            hijos.add(c2);
        }
      return hijos;
    }

    private Cromosoma mutacion(Cromosoma c) {
        if(new Random().nextDouble()<=VariablesIniciales.PROBABILIDAD_MUTACION)
        {
            int corte = new Random().nextInt(c.getGenes().length);
            c.getGenes()[corte] = c.getGenes()[corte] == 1 ?0:1;
            
        }
        return c;

    }

     ArrayList<Cromosoma> getIndividuos() {
        return cromosomas;
    }
     /// Toma los dos mejores de la poblacion y los devuelve
    private ArrayList<Cromosoma> getParElitista() {
        ArrayList<Cromosoma> croms = new ArrayList<>(cromosomas);
        Collections.sort(croms); //Ordena los cromosomas de menor a mayor segun la funcion objetivo. Ver metodo compareTo en clase Cromosoma
         ArrayList<Cromosoma> parCromosomas = new ArrayList<>();
         parCromosomas.add(croms.get(croms.size()-1));
         parCromosomas.add(croms.get(croms.size()-2));
        return parCromosomas;
    }

    
    
    
    
}
