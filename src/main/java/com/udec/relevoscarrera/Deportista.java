
package com.udec.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de ejecutar los hilos
 * @author Corin V
 */
public class Deportista extends Thread {
    /**
     * Nombre, almacena el nombre del equipo
     * inicio, indica cual es el inicio de cada deportista
     * posicion, indica la posicio actual de cada deportista
     * 
     */
    private String nombre;
    private int inicio;
    private PosicionE posicion;

    /**
     * Constructor de la clase
     * @param nombre del equipo
     * @param inicio de cada deportista
     * @param posicion del equipo en general
     */
    /**
     * Constructor de la clase Deportista
     * @param nombre del equipo
     * @param inicio del equipo
     * @param posicion del equipo
     */
    public Deportista(String nombre, int inicio, PosicionE posicion) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.posicion = posicion;
    }
    /**
     * Obtiene el nombre del equipo
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Asignar o actualizar el nombre del equipo
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la posicion inicial de cada deportista
     * @return posicion inicial
     */
    public int getInicio() {
        return inicio;
    }
    /**
     * Asigna o actualiza la posicion inicial
     * @param inicio 
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    /**
     * Obtiene la posicion del equipo en general
     * @return Objeto de tipo Posicion
     */
    public PosicionE getPosicion() {
        return posicion;
    }

    public void setPosicion(PosicionE posicion) {
        this.posicion = posicion;
    }

    /**
     * Metodo que ejecuta la carrera
     */
    
    @Override
    public void run(){
        int pasos=0;
        if(inicio==0){
            primerCorredor(pasos);      
        }else{
           esperar();
        }
        if(inicio==33){
            segundoCorredor(pasos);
        }else{
            esperar();
        }
        if(inicio==66){
            tercerCorredor(pasos);
        }else{
            esperar();
        }
    }
    /**
     * Metodo parar poner en espera los hilos mientras se ejecuta uno
     */
    private void esperar() {
        synchronized(posicion){
            try {
                posicion.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    /**
     * Metodo que sincroniza la carrera aqui se imprime las posiciones de los deportistas
     * @param paso paso del jugador
     * @param atr Atributo representativo
     */
     private synchronized  void correr (int paso, char atr) {   
        StringBuffer datoCarrera=new StringBuffer("0---------------------------------E--------------------------------F---------------------------------");                               
        StringBuffer dato=validarCarrera(datoCarrera, paso);   
        if(getNombre().equals("Equipo1")){
            dato.setCharAt(paso, atr);                
             System.out.println("\u001B[31m"+"Equipo1 "+dato);               
        }else{
            if(getNombre().equals("Equipo2")){
                dato.setCharAt(paso, atr);                                      
                System.out.println("\u001B[32m"+"Equipo2 "+dato);
            }else{
                    if(getNombre().equals("Equipo3")){
                        dato.setCharAt(paso, atr);                        
                        System.out.println("\u001B[33m"+"Equipo3 "+dato);                   
                    }
            }
        } 
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
        }         
        } 
     
    /**
     * Metodo que se usa para ejecutar la carrera del primer jugador
     * @param pasos del corredor
     */
    private void primerCorredor(int pasos) {
        while(inicio==0){
            corredoresP(33,'0',pasos);            
        }  
    }
    /**
     * Metodo que se usa para ejecutar la carrera del segundo jugador
     * @param pasos del corredor
     */
    private void segundoCorredor(int pasos) {
        while(inicio==33 && posicion.getPosicion() >=33 && posicion.getPosicion() <67){
            corredoresP(66,'E',pasos);            
        }
    
    }
  /**
     * Metodo que se usa para ejecutar la carrera del tercer jugador
     * @param pasos del corredor
     */
    private void tercerCorredor(int pasos) {      
        while(inicio==66  && posicion.getPosicion()>=66){
            try { 
                pasos=posicion.getPosicion()+(int) (Math.random()*3 + 1);
                if(pasos>=100){
                     posicion.setPosicion(100);
                     correr(posicion.getPosicion(),'F'); 
                     System.out.println("El ganador es el "+nombre+" \n");
                     System.exit(0); 
                     Thread.sleep(100);                   
                     break;
                }else{
                    posicion.setPosicion(pasos);
                    correr(posicion.getPosicion(),'F'); 
                }             
                
                limpiezaConsola();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Metodo 
     * @param datoCarrera en una cadena que contiene la pista de la carrera
     * @param paso es la posicion del corredor
     * @return un string con la posicion del corredor
     */
    private StringBuffer validarCarrera(StringBuffer datoCarrera, int paso) {
        StringBuffer dato;
        if(paso>=0 && paso<=33){
            datoCarrera.setCharAt(0, '-');
        }
        if(paso>33 && paso<=66){
            datoCarrera.setCharAt(0, '-');
            datoCarrera.setCharAt(34, '0');
        }
        if(paso>66){
            datoCarrera.setCharAt(0, '-');
            datoCarrera.setCharAt(34, '0');
            datoCarrera.setCharAt(67, 'E');
        }
        dato=datoCarrera;
        return dato;
    }
    /**
     * Metodo para notificar a los equipos del cambio
     */
    private void sincronizarEquipo() {
         synchronized(getPosicion()){                       
             try {
                 Thread.sleep(1000);
                 posicion.notifyAll();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
             }
                        
                        
         } 
    }
    /**
     * Metodo para primer y segundo corredor
     * @param valorM es el valor maximo por cada corredor
     * @param fig el caracter representativo
     * @param pasos posicion de cada corredor
     */
    private void corredoresP(int valorM, char fig, int pasos) {
        try { 
            if(posicion.getPosicion()==-1){
                pasos=0;                   
            }else{                   
                pasos=posicion.getPosicion()+(int) (Math.random()*3 + 1);
            }
            if(pasos>=valorM){
                inicio=-1;
                posicion.setPosicion(valorM);
                correr(posicion.getPosicion(),fig); 
                limpiezaConsola();
                sincronizarEquipo();
            }else{
                posicion.setPosicion(pasos);
                correr(posicion.getPosicion(),fig); 
                limpiezaConsola();
            }                                              
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
                     Logger.getLogger(Deportista.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    /**
     * Metodo para limipiar consola
     */
    public void limpiezaConsola(){
        for(int i=0; i<=2;i++)
            System.out.println("");
    
    }

}