package aplicacion;

import javax.swing.JOptionPane; //
import misclases.*; // Punto 16: Importa todas las clases del paquete misclases

public class Principal {

    // Método de la Parte 1
    public static void parte1() { //
        Persona obj1 = new Persona(); //
        Persona obj2 = new Persona("Manuel", "Valdez", 25); //

        System.out.println("Datos predeterminados de objeto obj1 son:"); //
        obj1.mostrarDatos(); //

        obj1.ingresoDatos(); //
        System.out.println("Campos modificados del objeto obj1 son:"); //
        obj1.mostrarDatos(); //

        System.out.println("Objeto obj2: Campos asignados con sobrecarga del constructor"); //
        obj2.mostrarDatos(); //

        System.exit(0); //
    }

    // Punto 17: Método estático parte2
    public static void parte2() {
        Tiempo hora1 = new Tiempo(); //

        String salida = "Hora inicial es: \n *hora universal: " +
                hora1.aStringUniversal() + "\n *hora estándar: " +
                hora1.aStringEstandar(); //

        hora1.establecerHora(18, 27, 6); //
        salida += "\n\nLa nueva hora universal es: " +
                hora1.aStringUniversal() +
                "\ny en forma estándar es: " + hora1.aStringEstandar(); //

        // Puntos 24 y 28: Modificación mediante setters encapsulados
        hora1.setHora(9); //
        hora1.setMinuto(52); //

        salida += "\n\nHora estandar modificada: " + hora1.aStringEstandar(); //
        JOptionPane.showMessageDialog(null, salida,
                "Prueba de clase Tiempo", JOptionPane.INFORMATION_MESSAGE); //

        // Prueba con horas e intervalos inválidos (demuestra la seguridad del encapsulamiento)
        hora1.establecerHora(-5, 8, 721); //
        salida = "Después de ajuste inválido de hora: " +
                "\nHora universal: " + hora1.aStringUniversal() +
                "\nHora estándar: " + hora1.aStringEstandar(); //

        JOptionPane.showMessageDialog(null, salida,
                "Prueba de la clase Tiempo1", JOptionPane.INFORMATION_MESSAGE); //

        System.exit(0); //
    }

    public static void main(String[] args) {
        // Punto 18: Se comenta parte1() y se llama a parte2()
        // parte1();
        parte2(); //
    }
}