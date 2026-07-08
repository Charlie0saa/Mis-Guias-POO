package EjercicioC1;

import javax.swing.JOptionPane;

public class EjercicioC3 {

    public static void main(String[] args) {

        double radio;
        double altura;
       //proceso
        String radioText =
                JOptionPane.showInputDialog("Digite el radio del tanque de combustible: ");

        radio = Double.parseDouble(radioText);

        if (radio <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un valor mayor que cero.");
            System.exit(0);
        }

        String alturaText =
                JOptionPane.showInputDialog("Digite el altura del tanque de combustible: ");
        altura = Double.parseDouble(alturaText);

        if (altura <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un valor mayor que cero.");
            System.exit(0);
        }

        System.out.println("radiio: " + radio);
        System.out.println("altura: " + altura);



        System.out.println("Su capacidad en litros es: " + calcularLitros(radio, altura));

        System.out.println("Su capacidad en kilogramos es: " + calcularKilogramos(radio, altura));
    }


    public static double calcularLitros(double radio, double altura) {

        double volumen = Math.PI * Math.pow(radio, 2) * altura;

        return volumen * 1000;
    }
    public static double calcularKilogramos(double radio, double altura) {

        final double DENSIDAD_GASOLINA = 0.750;

        double litros = calcularLitros(radio, altura);

        return litros * DENSIDAD_GASOLINA;
    }



}
