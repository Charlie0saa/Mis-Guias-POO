package EjerciciosSwitch;

import javax.swing.JOptionPane;

public class Controlswitch {
    public static void main(String[] args) {
        // Descomenta el método que quieras probar:

        switch1(3, -9, '+');
        // switch2();
    }

    // Ejemplo switch1: Operaciones aritméticas básicas usando switch
    public static void switch1(int a, int b, char op) {
        switch (op) {
            case '+':
                // Imprime mensaje como concatenación de varios String
                System.out.println("El resultado de " + a + " " + op + " " + b + " es " + (a + b));
                break;
            case '-':
                // Imprime mensaje basado en una cadena String con formato
                // %n: genera efecto de \n
                System.out.printf("El resultado de %d %c %d es %d %n", a, op, b, a - b);
                break;
            case '*':
                // Imprime signo de cada valor numérico (aunque sea positivo)
                System.out.printf("El resultado de %+d %c %+d es %d %n", a, op, b, a * b);
                break;
            case '/':
                // Conversión explícita a double para obtener división con decimales
                System.out.printf("El resultado de %d %c %d es %.4f%n", a, op, b, a / (double) b);
                break;
            default:
                System.out.printf("Error, simbolo (%c) no es un operador aritmetico%n", op);
                break;
        } // fin switch op
    }

    // Ejemplo switch2: Evaluar el botón presionado en un showConfirmDialog con switch
    public static void switch2() {
        String result = "?";
        int botonpresionado = JOptionPane.showConfirmDialog(null, "Quiere reemplazar su seleccion?");

        switch (botonpresionado) {
            case JOptionPane.CANCEL_OPTION:
                result = "Canceled";
                break;
            case JOptionPane.CLOSED_OPTION:
                result = "Closed";
                break;
            case JOptionPane.NO_OPTION:
                result = "No";
                break;
            case JOptionPane.YES_OPTION:
                result = "Yes";
                break;
        }

        System.out.println("Boton elegido del cuadro de dialogo: " + result);
    }
}