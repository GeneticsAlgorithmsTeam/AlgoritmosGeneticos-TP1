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
/// Represante un conjunto de medidas para una iteracion del algoritmo genético
public class StadisticUnit {
    private double max_fo; //maximo de la funcion objetivo
    private double min_fo; //minimo de la funcion objetivo
    private double promedio; //promedio de la funcion objetivo

    /**
     * @return the max_fo
     */
    public double getMax_fo() {
        return max_fo;
    }

    /**
     * @param max_fo the max_fo to set
     */
    public void setMax_fo(double max_fo) {
        this.max_fo = max_fo;
    }

    /**
     * @return the min_fo
     */
    public double getMin_fo() {
        return min_fo;
    }

    /**
     * @param min_fo the min_fo to set
     */
    public void setMin_fo(double min_fo) {
        this.min_fo = min_fo;
    }

    /**
     * @return the promedio
     */
    public double getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
