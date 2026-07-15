package Ejercicio6;

import javax.swing.JOptionPane;

public class Ejemplo1 {

    public static void main(String[] args) {

        dialogo1();

    }

    public static void dialogo1() {

        while (true) {

            try {

                String nombre = JOptionPane.showInputDialog(
                        "¿Cómo te llamas?");

                String entrada = JOptionPane.showInputDialog(
                        "¿Cuántos años tienes?");

                int edad = Integer.parseInt(entrada);

                JOptionPane.showMessageDialog(
                        null,
                        "Hola, " + nombre +
                                ". El año que viene tendrás " +
                                (edad + 1) + " años",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {

                System.out.println("Error en edad ingresada");

                JOptionPane.showMessageDialog(
                        null,
                        "Error en algun dato de entrada",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "Desea salir",
                        "Seleccione una opcion",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Si", "No"},
                        "Si");

                if (seleccion.equals("Si")) {

                    System.exit(0);
                    break;

                }

            } // fin catch

        } // fin while

    }

}