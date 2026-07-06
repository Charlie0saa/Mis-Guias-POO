//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Ejercicio2;

import java.util.Scanner;

public class Ejemplo2 {
    public Ejemplo2() {
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String nombre = "";
        System.out.print("Ingrese su nombre: ");
        nombre = lector.nextLine();
        System.out.print("Ahora ingrese su edad: ");
        int edad = lector.nextInt();
        System.out.println("\nNombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
    }
}
