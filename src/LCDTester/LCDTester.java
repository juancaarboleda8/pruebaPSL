/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LCDTester;

/**
 *
 * @author JuanCamiloArboleda
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        ImpresorLCD impresorLCD = new ImpresorLCD();
        String comando;
        int espacioDig;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                espacioDig = impresorLCD.validarNumeroYRango(comando); 
                do
                {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        listaComando.add(comando);
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            }

           impresorLCD.mostrarResultado(listaComando, espacioDig);
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }

}