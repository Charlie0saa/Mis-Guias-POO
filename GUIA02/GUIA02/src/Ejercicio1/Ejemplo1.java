package Ejercicio1;

import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {

        compararNumeros();

    }

    public static void compararNumeros() {

        Scanner reader = new Scanner(System.in);

        int Var1, Var2;

        System.out.print("Ingrese numero 1: ");
        Var1 = reader.nextInt();

        System.out.print("Ingrese numero 2: ");
        Var2 = reader.nextInt();

        if (Var1 == Var2) {
            System.out.println("Los numeros ingresados son iguales.");
        } else {
            System.out.println("Los numeros ingresados NO son iguales.");
        }

        reader.close();
    }
}