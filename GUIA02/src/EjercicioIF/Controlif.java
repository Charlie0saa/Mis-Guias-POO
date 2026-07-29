package EjercicioIF;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Controlif {

    public static void main(String[] args) {
        // Descomentar el metodo que se desea probar

        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        ejemplo4();
    }

    // Ejemplo 1: Comparar dos enteros usando Scanner
    static void ejemplo1() {
        Scanner reader = new Scanner(System.in);
        int Var1, Var2;

        System.out.print("Ingrese numero1: ");
        Var1 = reader.nextInt();

        System.out.print("Ingrese numero2: ");
        Var2 = reader.nextInt();

        if (Var1 == Var2) {
            System.out.print("Los numeros ingresados son iguales ");
        } else {
            System.out.println("Los numeros ingresados No son iguales ");
        }
    }

    // Ejemplo 2: Validar entradas en JOptionPane
    static void ejemplo2() {
        String v1 = "";
        v1 = JOptionPane.showInputDialog("Ingrese un valor");

        if (v1 == null) {
            JOptionPane.showMessageDialog(null, "Apretaste cancelar");
        } else {
            if (v1.equals("")) {
                JOptionPane.showMessageDialog(null, "No ingresaste nada");
            } else {
                JOptionPane.showMessageDialog(null, "El valor de V1 es: " + v1);
            }
        }
        System.exit(0);
    }

    // Ejemplo 3: Uso de showConfirmDialog
    static void ejemplo3() {
        int result = JOptionPane.showConfirmDialog(null, "Replace existing selection?");
        System.out.println("El numero devuelto por showConfirmDialog es: " + result);

        if (result == JOptionPane.YES_OPTION) {
            System.out.println("Yes");
        } else if (result == JOptionPane.NO_OPTION) {
            System.out.println("No");
        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancel");
        } else if (result == JOptionPane.CLOSED_OPTION) {
            System.out.println("Closed");
        }
        System.exit(0);
    }

    // Ejemplo 4: Cálculo de sueldo y descuentos (AFP, ISSS, Renta)
    static void ejemplo4() {
        String datos;
        double sueldo, afp = 0, isss, totalre, nsueldo, renta;

        datos = JOptionPane.showInputDialog("Ingrese el sueldo del empleado (a)");
        sueldo = Double.parseDouble(datos);

        if (sueldo > 300) {
            afp = (sueldo * 0.0625);
        }

        JOptionPane.showMessageDialog(null, "Este empleado tiene un sueldo de " + sueldo + " y el descuento del AFP es " + afp);

        datos = (String) JOptionPane.showInputDialog(
                null,
                "Ingrese el Sexo:\nSi es Masculino (M)\nSi es Femenino (F)",
                "Sexo del Empleado",
                JOptionPane.QUESTION_MESSAGE,
                null, // Icono por defecto
                new Object[]{"M", "F"},
                "F" // Opción por defecto
        );

        if ("M".equals(datos)) { // Si es de sexo Masculino
            isss = sueldo * 0.03;
            renta = sueldo * 0.10;
            totalre = afp + isss + renta;
            nsueldo = sueldo - totalre;

            JOptionPane.showMessageDialog(null,
                    "A este empleado se le retiene " + isss + " en concepto de ISSS\n" +
                            "Además se le retiene: " + renta + " en concepto de Renta\n" +
                            "Lo que hace un total de " + totalre + "\n" +
                            "Y su nuevo Sueldo es de: " + nsueldo);
        }
    }
}