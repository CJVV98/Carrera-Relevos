/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

/**
 * Esta clase almacena la posicion de los equipos
 * @author Corin V
 */
public class PosicionE {
    /*
    * La variable posicion almacena la posicion del equipo 
    */
    private int posicion;
    /**
     * Constructor de la clase Posicion
     * @param posicion este parametro indica la posicion del equipo dentro de la pista
     */
    public PosicionE(int posicion) {
        this.posicion = posicion;
    }
    
    /**
     * MEtodo para obtener la posicion
     * @return 
     */
    public int getPosicion() {
        return posicion;
    }
    /**
     * Metodo para actualizar la posicion
     * @param posicion 
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
