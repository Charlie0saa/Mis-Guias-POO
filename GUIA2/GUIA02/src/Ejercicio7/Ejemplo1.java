package Ejercicio7;

import javax.swing.JOptionPane;

public class Ejemplo1 {

    public static void main(String[] args) {

        dialogo2();

    }

    public static void dialogo2() {

        // Prueba de uso de título e icono por defecto en un cuadro de diálogo
        JOptionPane.showMessageDialog(
                null,
                "Informacion",
                "Mensaje de Informacion",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "Advertencia",
                "Mensaje de Advertencia",
                JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "Error",
                "Mensaje de Error",
                JOptionPane.ERROR_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "Sin Icono",
                "Mensaje de Texto Plano",
                JOptionPane.PLAIN_MESSAGE);

    }

}