package Ejercicio5SWCHYCICLOS;

import javax.swing.*;

public class Ejemplo3 {

    public static void main(String[] args) {

        int numero;

        System.out.println("Programa para calculo del factorial de un numero\n");

        String strnumero = JOptionPane.showInputDialog(
                "Ingrese un numero entero:");

        numero = Integer.parseInt(strnumero);

        factorial(numero);

    }

    public static void factorial(int n) {

        long resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
            System.out.printf("%d ", resultado);
        }

        JOptionPane.showMessageDialog(
                null,
                "El factorial de " + n + " es: " + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);

        System.out.printf("%nValor de %d! es %d%n", n, resultado);

    }

}