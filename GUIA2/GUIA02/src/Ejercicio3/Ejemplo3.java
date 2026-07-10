package Ejercicio3;

import javax.swing.*;
import java.util.Scanner;

public class Ejemplo3 {

    public static void main(String[] args) {

        Ejemplo3();
    }
    public static void Ejemplo3() {
        int result = JOptionPane.showConfirmDialog(null,
                "Replace existing selection?");
        System.out.println("El numero devuelto por showConfirmDialog es: " +result);

        if(result == JOptionPane.YES_OPTION)
            System.out.println("Yes");
        else if (result == JOptionPane.NO_OPTION)
            System.out.println("no");
        else if (result == JOptionPane.CANCEL_OPTION)
            System.out.println("Cancel");
        else if (result == JOptionPane.CLOSED_OPTION)
            System.out.println("Closed");

        System.exit(0);


    }
}
