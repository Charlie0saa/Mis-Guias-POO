//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Ejercicio5;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Ejemplo5 {
    public Ejemplo5() {
    }

    public static void main(String[] args) {
        String primernumero = JOptionPane.showInputDialog("Escriba el primer entero:");
        String segundonumero = JOptionPane.showInputDialog("Escriba el Segundo Entero:");
        int numero1 = Integer.parseInt(primernumero);
        int numero2 = Integer.parseInt(segundonumero);
        String resultado = "";
        if (numero1 == numero2) {
            resultado = resultado + numero1 + " == " + numero2;
        }

        if (numero1 != numero2) {
            resultado = resultado + numero1 + " != " + numero2;
        }

        if (numero1 < numero2) {
            resultado = resultado + "\n" + numero1 + " < " + numero2;
        }

        if (numero1 > numero2) {
            resultado = resultado + "\n" + numero1 + " > " + numero2;
        }

        if (numero1 <= numero2) {
            resultado = resultado + "\n" + numero1 + " <=" + numero2;
        }

        if (numero1 > numero2) {
            resultado = resultado + "\n" + numero1 + " >= " + numero2;
        }

        JOptionPane.showConfirmDialog((Component)null, resultado, "Resultado de la comparación", 1);
        System.exit(0);
    }
}
