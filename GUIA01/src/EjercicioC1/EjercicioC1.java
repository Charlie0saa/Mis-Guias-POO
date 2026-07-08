package EjercicioC1;
//este es el ejemplo04 modificado para no aceptar numeres negatives XD
import javax.swing.*;
import java.awt.*;

public class EjercicioC1 {

    public EjercicioC1() {
    }

    public static void main(String[] args) {

        String primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        String segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");

        int numero1 = Integer.parseInt(primernumero);
        int numero2 = Integer.parseInt(segundonumero);

        if (numero1 < 0 || numero2 < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se permiten números negativos."
            );
            System.exit(0);
        }

        int suma = numero1 + numero2;

        JOptionPane.showMessageDialog(
                null,
                "La suma es: " + suma,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}