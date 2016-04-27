/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pedro
 */
public class Util {
    public static ArrayList<Cromosoma> generarPoblacionInicial(int cant_poblacion, int cant_genes) {
        ArrayList<Cromosoma> cromosomas = new ArrayList<>();
        Random rnd = new Random();
        
        for (int i = 0; i < cant_poblacion; i++) {
            int[] genes = new int[cant_genes];
            
            for (int j = 0; j < cant_genes; j++) {
                genes[j] = (rnd.nextDouble()<0.5)?1:0;
            }
            cromosomas.add(new Cromosoma(genes));
        }
        
        return cromosomas;
    }
    //FIN metodo

    static void showResults(ArrayList<StadisticUnit> estadistica) {
         try {
            
            File newTextFile = new File("C:\\Users\\Pedro\\Documents/salida.csv");

            FileWriter fw = new FileWriter(newTextFile);
            
            DecimalFormat df = new DecimalFormat("#.###");
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            df.setRoundingMode(RoundingMode.DOWN);
            
             int indice =0;
             fw.write("Generacion"+";"+"Maximo"+";"+"Minimo"+";"+"Promedio"+'\n');
        for (StadisticUnit stadisticUnit : estadistica) {
            System.out.println("Poblacion: "+indice +" Maximo: " + stadisticUnit.getMax_fo() + " Minimo: " + stadisticUnit.getMin_fo() + " Promedio: " + stadisticUnit.getPromedio());
           
            fw.write(indice+";"+df.format(stadisticUnit.getMax_fo())+";"+df.format(stadisticUnit.getMin_fo())+";"+df.format(stadisticUnit.getPromedio())+'\n');
            
            indice++;
            
        }
            
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
       
    }
    
}
