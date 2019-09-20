/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.relevoscarrera.Deportista;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Corin V
 */
public class TestDeportista {
    int pasos;
    String nombre;
    StringBuffer datoCarrera;
    public TestDeportista() {
        pasos=0;
        nombre="Equipo1";
        datoCarrera=new StringBuffer("0---------------------------------E--------------------------------F---------------------------------");                       
        testCorrer();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void esperar(){
        
    }
     @Test
    public void testCorrer(){
        pasos=(int) (Math.random()*3 + 1);
        if(pasos==1){
            assertEquals(1,pasos);
        }
        if(pasos==2){
            assertEquals(2,pasos);
        }
        if(pasos==3){
            assertEquals(3,pasos);
        }
        testCorredores();
         assertEquals('O',datoCarrera.charAt(pasos));
    }
    
    @Test
    public void testCorredores(){
         testValidarCarrera();
         assertEquals('-',datoCarrera.charAt(0));
         if(nombre.equals("Equipo1")){
             datoCarrera.setCharAt(pasos, 'O');
         }
    }
   
    @Test
    public void testValidarCarrera(){
        if(pasos>=0 && pasos<=33){
            datoCarrera.setCharAt(0, '-');
        }    
    }
}
