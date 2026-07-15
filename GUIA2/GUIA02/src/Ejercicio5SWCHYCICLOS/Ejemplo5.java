package Ejercicio5SWCHYCICLOS;

public class Ejemplo5 {

    public static void main(String[] args) {

        ciclos3();

    }

    public static void ciclos3() {

        // Declara e inicializa un vector
        int Numero[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        int Suma = 0;

        // For clásico
        for (int indice = 0; indice < 10; indice++) {

            Suma = Suma + Numero[indice];

        }

        System.out.println("Total con for clasico: " + Suma);

        Suma = 0;

        // For mejorado
        for (int valor : Numero) {

            Suma += valor;

        }

        System.out.println("Total con for mejorado: " + Suma);

    }

}