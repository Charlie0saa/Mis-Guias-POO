package EjercicioC1;

import javax.swing.JOptionPane;

public class EjercicioC2 {

    public static void main(String[] args) {

        double capacitor1;
        double capacitor2;
        double capacitor3;
//capacitor uno
        String capacitor1Texto =
                JOptionPane.showInputDialog("Digite el valor del capacitor 1:");

        if (capacitor1Texto == null || capacitor1Texto.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }
        capacitor1 = Double.parseDouble(capacitor1Texto);

        if (capacitor1 <= 0 ){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }
        //capacitor dos
        String capacitor2Texto =
                JOptionPane.showInputDialog("Digite el valor del capacitor 2:");

        if (capacitor2Texto == null || capacitor2Texto.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }
        capacitor2 = Double.parseDouble(capacitor2Texto);

        if (capacitor2 <= 0 ){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }
        //capacitor tres
        String capacitor3Texto =
                JOptionPane.showInputDialog("Digite el valor del capacitor 3:");

        if (capacitor3Texto == null || capacitor3Texto.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }
        capacitor3 = Double.parseDouble(capacitor3Texto);

        if (capacitor3 <= 0 ){
            JOptionPane.showMessageDialog(null,
                    "no ingreso un valor correcto.");
            System.exit(0);
        }

        double paralelo = capcitorParalelo(capacitor1, capacitor2, capacitor3);

        double serie = capacitorSerie(capacitor1, capacitor2, capacitor3);

        System.out.println("Capacitor 1: " + capacitor1);
        System.out.println("Capacitor 2: " + capacitor2);
        System.out.println("Capacitor 3: " + capacitor3);

        System.out.println("Capacitor equivalente en paralelo: " + paralelo);
        System.out.println("Capacitor equivalente en serie: " + serie);
    }

    public static double capcitorParalelo(double c1, double c2, double c3){
        return c1+c2+c3;
    }
    public static double capacitorSerie(double c1, double c2, double c3) {
        return 1 / ((1.0 / c1) + (1.0 / c2) + (1.0 / c3));
    }
}