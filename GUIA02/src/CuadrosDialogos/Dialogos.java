package CuadrosDialogos;

import javax.swing.JOptionPane;

public class Dialogos {

    public static void main(String[] args) {
        // Descomenta el método que quieras probar:

        // dialogo1();
        dialogo2();
    }

    // Ejemplo dialogo1: Bucle infinito con manejo de excepciones try-catch
    public static void dialogo1() {
        while (true) {
            try {
                String nombre = JOptionPane.showInputDialog("¿Cómo te llamas?");
                String entrada = JOptionPane.showInputDialog("¿Cuántos años tienes?");
                int edad = Integer.parseInt(entrada);

                JOptionPane.showMessageDialog(
                        null,
                        "Hola, " + nombre + ". El año que viene tendrás " + (edad + 1) + " años",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception e) {
                System.out.println("Error en edad ingresada");
                JOptionPane.showMessageDialog(
                        null,
                        "Error en algún dato de entrada",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "¿Desea Salir?",
                        "Seleccione una opción",
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null para icono por defecto
                        new Object[]{"Si", "No"},
                        "Si"
                );

                if (seleccion != null && seleccion.equals("Si")) {
                    System.exit(0);
                }
            } // fin de catch
        } // fin de while
    }

    // Ejemplo dialogo2: Distintos tipos de íconos en JOptionPane
    public static void dialogo2() {
        // Prueba de uso de título e ícono por defecto en un cuadro de diálogo
        JOptionPane.showMessageDialog(
                null,
                "Información",
                "Mensaje De Información",
                JOptionPane.INFORMATION_MESSAGE
        );

        JOptionPane.showMessageDialog(
                null,
                "Advertencia",
                "Mensaje de Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        JOptionPane.showMessageDialog(
                null,
                "Error",
                "Mensaje de Error",
                JOptionPane.ERROR_MESSAGE
        );

        JOptionPane.showMessageDialog(
                null,
                "Sin Ícono",
                "Mensaje de Texto Plano",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}