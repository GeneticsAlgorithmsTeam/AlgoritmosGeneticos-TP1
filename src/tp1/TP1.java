/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;
/**
 *
 * @author Pedro
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

         
         
         // Para ir guardando los valores maximo, minimo, y promedio de la funcion objetvo
         ArrayList<StadisticUnit> estadistica = new ArrayList<>();
         //Creo la poblacion inicial
         Poblacion poblacionInicial = new Poblacion(Util.generarPoblacionInicial(VariablesIniciales.POBLACION_INICIAL,VariablesIniciales.CANT_GENES));
         estadistica.add(poblacionInicial.getStadisticUnit());
         //mostrarpoblacion(poblacionInicial);
         for (int i = 0; i < VariablesIniciales.CICLOS; i++) {
            Poblacion nuevaPoblacion = new Poblacion(poblacionInicial.generarNuevaPoblacion());
            //mostrarpoblacion(nuevaPoblacion);
            estadistica.add(nuevaPoblacion.getStadisticUnit());
        }
        
        Util.showResults(estadistica);
         
    }

   // private static void mostrarpoblacion(Poblacion p) {
     // ArrayList<Cromosoma> individuos =  p.getIndividuos();
      //System.out.println(individuos.get(0).getGenes().toString());
    //}
    
}
