package semaforodos;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.*;
/**
 *
 * @author Daniel CAVS
 * semaforo hecho con hilos 
 */

public class Proceso implements Runnable {

    public boolean iterar;
    public JButton rojo;
    public JButton amarillo;
    public JButton verde;
    public JTextField texto;
    public int contador = 0, temp = 0, temp2 = 0, temp3 = 0, temp4 = 0;

    public Proceso(JButton entrada1, JButton entrada2, JButton entrada3, JTextField entrada4) {
        this.rojo = entrada1;
        this.amarillo = entrada2;
        this.verde = entrada3;
        this.texto = entrada4;
    }

    @Override
    public void run() {
        while (iterar) {
            contador++;
            if (contador >= 1 && contador <= 30) {
                temp++;
                texto.setText(" " + temp);
            }
            if (contador == 1) {
                rojo.setBackground(Color.red);
                amarillo.setBackground(Color.gray);
                verde.setBackground(Color.gray);
            }
            if (contador >= 30 && contador <= 33) {
                temp2++;
                texto.setText(" " + temp2);
            }
            if (contador == 30) {
                rojo.setBackground(Color.gray);
                amarillo.setBackground(Color.yellow);
                verde.setBackground(Color.gray);
            }
            if (contador >= 33 && contador <= 63) {
                temp3++;
                texto.setText(" " + temp3);
            }
            if (contador == 33) {
                rojo.setBackground(Color.gray);
                amarillo.setBackground(Color.gray);
                verde.setBackground(Color.green);
            }
            if (contador >= 63 && contador <= 66) {
                temp4++;
                texto.setText(" " + temp4);
            }
            if (contador == 63) {
                rojo.setBackground(Color.gray);
                amarillo.setBackground(Color.yellow);
                verde.setBackground(Color.gray);
            }
            if (contador == 67) {
                contador = 0;
                temp = 0;
                temp2 = 0;
                temp3 = 0;
                temp4 = 0;
            }
            try {
                sleep(1000);
            } catch (Exception e) {
            }

        }
    }

    public void start() {
        iterar = true;
        new Thread(this).start();
    }

    public void detener() {
        iterar = false;
    }

    public void reiniciar() {
        contador = 0;
        temp = 0;
        temp2 = 0;
        temp3 = 0;
        temp4 = 0;
        texto.setText(" ");
        
    }

}
