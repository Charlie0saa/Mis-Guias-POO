package EjerciciosBucles;

import javax.swing.JOptionPane;

public class CiclosJava {
    public static void main(String[] args) {
        // Descomenta el método que quieras probar:

        // ciclos1();
        // ciclos2();
        ciclos3();
    }

    // Método para calcular el factorial de un número n
    public static void factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
        }

        JOptionPane.showMessageDialog(
                null,
                "El factorial de " + n + " es: " + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.out.printf("\nValor de %d! es %d\n", n, resultado);
    }

    // Ejemplo ciclos1: Lee un número entero e invoca al método factorial
    public static void ciclos1() {
        int numero;
        System.out.println("Programa para calculo del factorial de un numero\n");
        String strnumero = JOptionPane.showInputDialog("Ingrese Numero entero: ");
        numero = Integer.parseInt(strnumero);
        factorial(numero);
    }

    // Ejemplo ciclos2: Calcula sueldo mayor, menor y cuántos ganan más de $300 entre 5 empleados
    public static void ciclos2() {
        String leer;
        double sueldo, mayor = 0, menor = 0;
        int i = 1, contador = 0;

        while (i <= 5) {
            leer = JOptionPane.showInputDialog("Ingrese el Sueldo del Empleado " + i);
            sueldo = Double.parseDouble(leer);

            if (sueldo > 300) contador = contador + 1;
            if (sueldo > mayor) mayor = sueldo;
            if (menor == 0) menor = sueldo;
            if (sueldo < menor) menor = sueldo;

            i++;
        }

        JOptionPane.showMessageDialog(null,
                "El sueldo Mayor es de $: " + mayor +
                        "\nEl sueldo Menor es de $: " + menor +
                        "\n" + contador + " Empleados tienen un sueldo mayor de $300");
    }

    // Ejemplo ciclos3: Recorrido de arreglo con 'for' clásico y 'for' mejorado (for-each)
    static void ciclos3() {
        // Declara e inicializa un vector
        int Numero[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int Suma = 0; // acumulador

        // For clásico
        for (int indice = 0; indice < 10; indice++) {
            Suma = Suma + Numero[indice];
        }
        System.out.println("Total con for clasico: " + Suma);

        Suma = 0; // Reinicializa acumulador

        // For mejorado (for-each)
        for (int valor : Numero) {
            Suma += valor;
        }
        System.out.println("Total con for mejorado: " + Suma);
    }
}