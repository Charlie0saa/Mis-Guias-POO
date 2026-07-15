package Ejercicio5SWCHYCICLOS;

import javax.swing.*;

public class Ejemplo2 {

    public static void main(String[] args) {

        switch2(4, -9, '+');



    }

    // <> {} ''
    public static void switch2(int a, int b, char op) {

        String result = "?";
        int botonpresionado = JOptionPane.showConfirmDialog(null,
                "Quiere reemplazar su seleccion?");

        switch (botonpresionado){
            case JOptionPane.CANCEL_OPTION:
                result = "Canceld";
                break;
            case JOptionPane.CLOSED_OPTION:
                result = "Closed";
                break;
            case JOptionPane.NO_OPTION:
                result = "No";
            case JOptionPane.YES_OPTION:
                result = "Yes";
                break;
        }

        System.out.println("Boton elegido del cuadro de dialogo:" +result);

    }

}

