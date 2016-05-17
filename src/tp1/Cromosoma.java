/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author Pedro
 */
public final class Cromosoma implements Comparable<Cromosoma>{
    private final int[] genes;
    private final double representacionDecimal;
    private final double fobjValue;
    
    public Cromosoma(int[] genes) {
        this.genes = genes;
        this.representacionDecimal = pasaje();
        this.fobjValue = this.evalFuncionObjetivo();
    }

    double evalFuncionObjetivo() {
        return Math.pow((this.getRepresentacionDecimal() / Math.pow(2, 30) - 1), 2);
    }
    
    public double pasaje()
    {
            double suma=0;
            for (int j=0;j<=this.genes.length-1;j++)
            {
                suma = suma + Math.pow(2,j)*genes[j];
            }
            return suma;
    }

    /**
     * @return the representacionDecimal
     */
    public double getRepresentacionDecimal() {
        return representacionDecimal;
    }

    int[] getGenes() {
 
        return genes;
    }

    @Override
    public int compareTo(Cromosoma o) {
        return new Double(this.evalFuncionObjetivo()).compareTo(new Double(o.evalFuncionObjetivo()));
    }
    

    
    
}
