//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Ejercicio4;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Ejemplo4 {
    public Ejemplo4() {
    }

    public static void main(String[] args) {
        String primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        String segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");
        int numero1 = Integer.parseInt(primernumero);
        int numero2 = Integer.parseInt(segundonumero);
        int suma = numero1 + numero2;
        JOptionPane.showMessageDialog((Component)null, "La suma es:" + suma, "Resultado", -1);
        System.exit(0);
    }
}
