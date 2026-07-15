package Ejercicio5SWCHYCICLOS;

import javax.swing.JOptionPane;

public class Ejemplo4 {

    public static void main(String[] args) {

        ciclos2();

    }

    public static void ciclos2() {

        String leer;
        double sueldo, mayor = 0, menor = 0;
        int i = 1, contador = 0;

        while (i <= 5) {

            leer = JOptionPane.showInputDialog(
                    "Ingrese el sueldo del empleado " + i);

            sueldo = Double.parseDouble(leer);

            if (sueldo > 300)
                contador = contador + 1;

            if (sueldo > mayor)
                mayor = sueldo;

            if (menor == 0)
                menor = sueldo;

            if (sueldo < menor)
                menor = sueldo;

            i++;
        }

        JOptionPane.showMessageDialog(
                null,
                "El sueldo mayor es de $" + mayor +
                        "\nEl sueldo menor es de $" + menor +
                        "\n" + contador +
                        " empleados tienen un sueldo mayor de $300");

    }

}