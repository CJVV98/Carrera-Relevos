/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

/**
 * En esta clase se inicializa los hilos
 * @author Corin V
 */
public class Logica {
    /**
     * Constructor de la clase aqui se llama el imprimir pista y solicitar hilos
     */
   public Logica(){
      soliciar();
    }
   /**
    * Metodo para inicializar los hilos
    */
    private void soliciar() {
        PosicionE posicionE1=new PosicionE(-1);
        PosicionE posicionE2=new PosicionE(-1);
        PosicionE posicionE3=new PosicionE(-1);
        Deportista deportistaG11=new Deportista("Equipo1",0,posicionE1);
        Deportista deportistaG21=new Deportista("Equipo1",33,posicionE1);
        Deportista deportistaG31=new Deportista("Equipo1",66,posicionE1);
        Deportista deportistaG12=new Deportista("Equipo2",0,posicionE2);
        Deportista deportistaG22= new Deportista("Equipo2",33,posicionE2);
        Deportista deportistaG32=new Deportista("Equipo2",66,posicionE2);
        Deportista deportistaG13=new Deportista("Equipo3",0,posicionE3);
        Deportista deportistaG23=new Deportista("Equipo3",33,posicionE3);
        Deportista deportistaG33=new Deportista("Equipo3",66,posicionE3);    
        deportistaG11.start();
        deportistaG12.start();
        deportistaG13.start();
        deportistaG21.start();
        deportistaG22.start();
        deportistaG23.start();
        deportistaG31.start();
        deportistaG32.start();
        deportistaG33.start();
       
    }
  
}
